import org.junit.Assert;
import org.junit.Test;

/**
 * Given a binary tree, find the lowest common ancestor of two given nodes in the tree.
 *
 * @see http://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-i.html
 */
public class LowestCommonAncestor {
	/**
	 * Definition for binary tree
	 */
	static class Node {
		int val;
		Node left;
		Node right;

		Node(int x) {
			val = x;
		}
	}

	Node LCA(Node root, Node p, Node q) {
		if (root == null) {
			return null;
		}

		if (root == p || root == q) {
			return root;
		}

		Node l = LCA(root.left, p, q);
		Node r = LCA(root.right, p, q);
		if (l != null & r != null) {
			return root;
		}
		return l != null ? l : r;
	}

	@Test
	public void test() {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		Assert.assertEquals(20,
				LCA(root, root.right, root.left.right.right).val);
		Assert.assertEquals(12,
				LCA(root, root.left.right.left, root.left.right.right).val);
	}
}
