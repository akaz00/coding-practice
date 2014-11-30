import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;


/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @see https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 *
 */
public class BinaryTreePreorderTraversal {
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
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();

		if (root != null) {
			stack.push(root);
		}
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			result.add(current.val);
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}			
		}
		return result;
	}
	
	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		Assert.assertEquals(Arrays.asList(1,2,3), preorderTraversal(root));
		
		root = new TreeNode(3);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		System.out.println(preorderTraversal(root));
		Assert.assertEquals(Arrays.asList(3,1,2), preorderTraversal(root));

	}	
}
