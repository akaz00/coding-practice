import org.junit.Assert;
import org.junit.Test;

public class LongestDistance {
	/**
	 * Definition for binary tree
	 */
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	private int getLongestDistance(TreeNode root) {
		if (root == null) {
			return 1;
		}

		return Math.max(getHeight(root.left) + getHeight(root.right) + 1, Math
				.max(getLongestDistance(root.left),
						getLongestDistance(root.right)));
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		Assert.assertEquals(3, getLongestDistance(root));
	}
}
