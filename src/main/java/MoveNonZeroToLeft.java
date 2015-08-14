import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array of integers.
 * 
 * Move all non-zero elements to the left of all zero elements.
 *
 * @see http://www.careercup.com/question?id=5668212962230272
 */
public class MoveNonZeroToLeft {
	void move(int[] A) {
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				A[j++] = A[i];
			}
		}
		for (; j < A.length; j++) {
			A[j] = 0;
		}
	}

	@Test
	public void test() {
		int[] A = { 0, 1, 2, 0, 3, 0, 4 };
		move(A);
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 0, 0, 0 }, A);
	}
}
