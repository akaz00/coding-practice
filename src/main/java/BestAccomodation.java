/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class BestAccomodation {
	public static void main(String[] args) {
		System.out.println(getMaxTotalNights(new int[] { 2, 1, 1, 2 }));
		System.out.println(getMaxTotalNights(new int[] { 1, 2, 3 }));
		System.out.println(getMaxTotalNights(new int[] { 1, 5, 3 }));
		System.out.println(getMaxTotalNights(new int[] { 2, 3, 10, 2 }));
	}

	static int getMaxTotalNights(int[] nights) {
		if (nights.length == 1) {
			return nights[0];
		}
		return Math.max(getMaxTotalNights(nights, 0), getMaxTotalNights(nights, 1));
	}

	static int getMaxTotalNights(int[] nights, int index) {
		if (index == nights.length - 1) {
			return nights[index];
		}
		if (index > nights.length - 1) {
			return 0;
		}
		return Math.max(nights[index] + getMaxTotalNights(nights, index + 2),
				nights[index] + getMaxTotalNights(nights, index + 3));
	}

}

// { 2, 1, 1, 2 } -> 4
// { 1, 2, 3 } -> 4
// { 1, 5, 3 } -> 5
// { 2, 3, 10, 2} -> 12
