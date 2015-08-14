import org.junit.Assert;
import org.junit.Test;
/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * 	A = [2,3,1,1,4], return true.
 * 
 * 	A = [3,2,1,0,4], return false.
 *
 * @see https://oj.leetcode.com/problems/jump-game/
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > max) {
				return false;
			}
			max = Math.max(A[i] + i, max);
		}
		return true;
	}

	@Test
	public void test() {
		Assert.assertTrue(canJump(new int[] { 2, 0 }));
		Assert.assertTrue(canJump(new int[] { 2, 3, 1, 1, 4 }));
		Assert.assertFalse(canJump(new int[] { 3, 2, 1, 0, 4 }));
	}
}
