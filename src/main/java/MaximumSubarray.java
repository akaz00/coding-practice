import org.junit.Assert;
import org.junit.Test;
/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * More practice:
 *  If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *  
 * @See https://oj.leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

	public static int maxSubArray(int... arr) {
		int sum = 0;
		int max = arr[0];
		for (int i : arr) {
			sum += i;
			if (i > sum) {
				sum = i;
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	@Test
	public void test() {
		Assert.assertEquals(3, maxSubArray(1, 2));
		Assert.assertEquals(1, maxSubArray(1));
		Assert.assertEquals(-1, maxSubArray(-1));
		Assert.assertEquals(6, maxSubArray(-2, 1, -3, 4, -1, 2, 1, -5, 4));
	}
}
