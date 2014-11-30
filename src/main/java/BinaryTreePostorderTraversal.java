import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * 
 * Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @see https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {
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

	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		LinkedList<Integer> result = new LinkedList<Integer>();

		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			result.addFirst(current.val);
			if (current.left != null) {
				stack.push(current.left);
			}
			if (current.right != null) {
				stack.push(current.right);
			}
		}
		return result;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		Assert.assertEquals(Arrays.asList(3, 2, 1), postorderTraversal(root));
	}
}
