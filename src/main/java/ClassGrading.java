import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

public class ClassGrading {
	private final static String SEPARATOR = ", ";

	static String[] grade(String[] grades) {
		Grade[] arr = new Grade[grades.length];
		int i = 0;
		for (String line : grades) {
			String[] row = line.split(SEPARATOR, 3);
			arr[i++] = new Grade(row[0], row[1],
					row.length > 2 ? row[2].split(SEPARATOR) : new String[0]);
		}
		Arrays.sort(arr);

		i = 0;
		String[] result = new String[grades.length];
		for (Grade grade : arr) {
			result[i++] = grade.format();
		}
		return result;
	}

	static class Grade implements Comparable<Grade> {
		String firstName;
		String lastName;
		Integer[] scores = new Integer[5];
		Integer percentage;
		char grade;
		char rank;

		public Grade(String firstName, String lastName, String[] scoreStrings) {
			this.firstName = firstName;
			this.lastName = lastName;
			int i = 0;
			float sum = 0;
			for (String s : scoreStrings) {
				int score = Integer.valueOf(s);
				scores[i++] = score;
				sum += score;
			}
			Arrays.fill(scores, scoreStrings.length, 5, 0);
			Arrays.sort(scores, Collections.reverseOrder());
			percentage = (int) Math.ceil(sum / 5);
			grade = getGrade();
			rank = getRank();
		}

		private char getRank() {
			if (percentage != 100 && grade != 'F') {
				int mod = percentage % 10;
				if (mod <= 3) {
					return '-';
				}
				if (mod >= 7 && grade != 'A') {
					return '+';
				}
			}
			return 0;
		}

		private char getGrade() {
			if (percentage > 89) {
				return 'A';
			}
			if (percentage > 79) {
				return 'B';
			}
			if (percentage > 69) {
				return 'C';
			}
			if (percentage > 59) {
				return 'D';
			}
			return 'F';
		}

		String format() {
			StringBuilder result = new StringBuilder();
			result.append(lastName);
			result.append(SEPARATOR);
			result.append(firstName);
			result.append(SEPARATOR);
			result.append(percentage);
			result.append(SEPARATOR);
			result.append(grade);
			result.append(rank != 0 ? rank : "");
			result.append(": ");
			for (int score : scores) {
				result.append(score);
				result.append(SEPARATOR);
			}
			int len = result.length();
			result.delete(len - 2, len);
			return result.toString();
		}

		@Override
		public int compareTo(Grade grade) {
			return (percentage).compareTo(grade.percentage);
		}
	}

	@Test
	public void test() {
		Assert.assertArrayEquals(new String[] {
				"Quux, Baz, 72, C-: 90, 90, 90, 90, 0",
				"Bar, Foo, 77, C+: 98, 85, 81, 79, 40" }, grade(new String[] {
				"Foo, Bar, 79, 81, 98, 40, 85", "Baz, Quux, 90, 90, 90, 90" }));
		Assert.assertArrayEquals(
				new String[] { "Bar, Foo, 52, F: 82, 82, 72, 11, 10" },
				grade(new String[] { "Foo, Bar, 11, 82, 72, 82, 10" }));
	}
}
