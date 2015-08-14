import org.junit.Assert;
import org.junit.Test;

/**
 * Write code to merge 3 sorted arrays of integers (all different sizes) into a
 * single sorted array
 */
public class ThreeSortedArrayMerge {
	public int[] merge(int arr1[], int[] arr2, int[] arr3) {
		// swap in order.
		if (arr1.length > arr2.length) {
			int[] tmp = arr2;
			arr2 = arr1;
			arr1 = tmp;
		}
		if (arr2.length > arr3.length) {
			int[] tmp = arr3;
			arr3 = arr2;
			arr2 = tmp;
		}
		int len1 = arr1.length;
		int len2 = arr2.length;
		int len3 = arr3.length;
		int len = len1 + len2 + len3;
		int result[] = new int[len];
		int i1 = 0, i2 = 0, i3 = 0;
		for (int i = 0; i < len; i++) {
			int min;
			// find minimum among 3 items.
			if (i1 < len1 && i2 < len2 && i3 < len3) {
				min = Math.min(arr1[i1], arr2[i2]);
				min = Math.min(min, arr3[i3]);
			} else if (i1 < len1 && i2 < len2) {
				min = Math.min(arr1[i1], arr2[i2]);
			} else if (i1 < len1 && i3 < len3) {
				min = Math.min(arr1[i1], arr3[i3]);
			} else if (i2 < len2 && i3 < len3) {
				min = Math.min(arr1[i2], arr3[i3]);
			} else if (i1 < len1) {
				result[i] = arr1[i1];
				i1++;
				continue;
			} else if (i2 < len2) {
				result[i] = arr3[i2];
				i2++;
				continue;
			} else {
				result[i] = arr3[i3];
				i3++;
				continue;
			}

			if (i1 < len1 && min == arr1[i1]) {
				result[i] = min;
				i1++;
				continue;
			}
			if (i2 < len2 && min == arr2[i2]) {
				result[i] = min;
				i2++;
				continue;
			}
			result[i] = min;
			i3++;
		}
		return result;
	}

	@Test
	public void test() {
		int[] arr1 = { 2, 4, 6, 8, 9, 12, 14, 16 };
		int[] arr2 = { 3, 6, 7, 9, 22, 25, 28 };
		int[] arr3 = { 2, 5, 7, 8, 10, 11, 16 };
		Assert.assertArrayEquals(new int[] { 2, 2, 3, 4, 5, 6, 6, 7, 7, 8, 8,
				9, 9, 10, 11, 12, 14, 16, 16, 22, 25, 28 },
				merge(arr1, arr2, arr3));
	}
}
