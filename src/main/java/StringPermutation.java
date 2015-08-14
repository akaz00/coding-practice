import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class StringPermutation {
	static Set<String> printPerm(String str, int numChars) {
		Set<String> result = new HashSet<>();
		printPerm(result, str, "", numChars);
		return result;
	}

	static void printPerm(Set<String> set, String str, String prefix, int numChars) {
		if (numChars == 0) {
			set.add(prefix);
		}

		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if (prefix.indexOf(c) != -1) {
				continue;
			}
			printPerm(set, str, prefix + c, numChars - 1);
		}
	}

	@Test
	public void test() {
		System.out.println(printPerm("abc", 2));
	}
}
