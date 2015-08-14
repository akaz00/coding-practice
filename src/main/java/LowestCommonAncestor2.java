import org.junit.Assert;
import org.junit.Test;

/**
 * Given a binary tree, find the lowest common ancestor of two given nodes in
 * the tree. Each node contains a parent pointer which links to its parent.
 *
 * @see http
 *      ://leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-
 *      ii.html
 */
public class LowestCommonAncestor2 {
	/**
	 * Definition for binary tree
	 */
	static class Node {
		int val;
		Node parent;

		Node(int x) {
			val = x;
		}
	}

	int getHeight(Node p) {
		int height = 0;
		while (p != null) {
			height++;
			p = p.parent;
		}
		return height;
	}

	Node LCA(Node root, Node p, Node q) {
		int h1 = getHeight(p);
		int h2 = getHeight(q);
		// swap both nodes in case p is deeper than q.
		if (h1 > h2) {
			int t = h2;
			h2 = h1;
			h1 = t;

			Node tmp = q;
			q = p;
			p = tmp;
		}
		// invariant: h1 <= h2.
		int dh = h2 - h1;
		for (int h = 0; h < dh; h++) {
			q = q.parent;
		}
		while (p != null && q != null) {
			if (p == q) {
				return p;
			}
			p = p.parent;
			q = q.parent;
		}
		return null; // p and q are not in the same tree

	}

	@Test
	public void test() {
		Node root = new Node(20);

		Node l1 = new Node(14);
		Node l2 = new Node(10);
		Node l3 = new Node(12);
		l1.parent = l3;
		l2.parent = l3;
		Node l4 = new Node(4);
		Node l5 = new Node(8);
		l3.parent = l5;
		l4.parent = l5;
		Node l6 = new Node(22);
		l5.parent = root;
		l6.parent = root;
		Assert.assertEquals(20, LCA(root, l6, l1).val);
		Assert.assertEquals(12, LCA(root, l2, l1).val);
	}
}
