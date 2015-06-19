import org.junit.Assert;
import org.junit.Test;

// radix sort
// input ( 123, 957, 700)
// itr1: ( 700, 123, 957)
// itr2: ( 700, 123, 957)
// itr3: ( 123, 700, 957)

public class RadixSort {
	int[] radixSort(int[] input) {
		int maxDigit = -1;
		for (int item : input) {
			maxDigit = Math.max(maxDigit, item);
		}
		for (int i = 1; i <= 100000000 /* 1 billion */; i *= 10) {
			Integer[][] arr = new Integer[10][input.length];
			for (int j = 0; j < input.length; j++) {
				int digit = (input[j] / i) % 10;
				for (int n = 0; n < input.length; n++) {
					if (arr[digit][n] == null) {
						arr[digit][n] = input[j];
						break;
					}
				}
			}
			int k = 0;
			for (Integer[] innerArr : arr) {
				if (innerArr != null) {
					for (Integer item : innerArr) {
						if (item != null) {
							input[k++] = item;
						}
					}
				}
			}
		}
		return input;
	}

	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] { 123, 700, 957 },
				radixSort(new int[] { 123, 957, 700 }));
	}
}
