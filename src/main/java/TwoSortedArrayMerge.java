import org.junit.Test;

public class TwoSortedArrayMerge {
	static void mergeArray(int[] a, int[] b, int M) {
		// Arrays.sort(b);
		int i = M - 1;
		int j = M * 2 - 1;

		int len = j;

		while (len > -1) {
			if (i > -1 && j > -1) {
				if (b[j] >= a[i]) {
					b[len] = b[j];
					j--;
				} else {
					b[len] = a[i];
					i--;
				}
			} else if (i > -1) {
				b[len] = a[i];
				i--;
			}
			len--;
		}
	}

	@Test
	public void test() {
		int[] a = { 1, 2, 4 };
		int[] b = new int[6];
		b[0] = 3;
		b[1] = 5;
		b[2] = 6;
		mergeArray(a, b, 3);
		for(int i : b) {
			System.out.println(i);
		}
	}
}
