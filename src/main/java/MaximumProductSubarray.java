import org.junit.Assert;
import org.junit.Test;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @See https://oj.leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {
	public int maxProduct(int... A) {
		int max = A[0];
		int min = A[0];
		int result = A[0];
		for (int i = 1; i < A.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
			min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
			if (max > result) {
				result = max;
			}
		}
		return result;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, maxProduct(0, 2));
		Assert.assertEquals(-2, maxProduct(-2));
		Assert.assertEquals(12, maxProduct(-4, -3));
		Assert.assertEquals(4, maxProduct(4, -3));
		Assert.assertEquals(6, maxProduct(2, 3, -2, 4));
		Assert.assertEquals(24, maxProduct(-2, 3, -4));
		Assert.assertEquals(1, maxProduct(-3, 0, 1, -2));
		Assert.assertEquals(24, maxProduct(2, -5, -2, -4, 3));
	}
}
