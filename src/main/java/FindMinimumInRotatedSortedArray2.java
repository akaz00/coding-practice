import org.junit.Assert;
import org.junit.Test;

/**
 * * Follow up for "Find Minimum in Rotated Sorted Array":
 * * What if duplicates are allowed?
 * * Would this affect the run-time complexity? How and why?
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @See https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumInRotatedSortedArray2 {
	public static int findMin(int... num) {
		int firstItem = num[0];
		int left = 0;
		int right = num.length - 2;

		while (left <= right) {
			int middle = (left + right) / 2;
			if (num[middle] >= firstItem && num[middle + 1] <= firstItem
					&& num[middle] > num[middle + 1]) {
				return num[middle + 1];
			}
			if (num[middle + 1] >= num[middle] && num[middle] >= firstItem) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}

		return firstItem;
	}

	@Test
	public void test() {
		Assert.assertEquals(0, findMin(4, 5, 6, 7, 0, 1, 2));
	}
}
