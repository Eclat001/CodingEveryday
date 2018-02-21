package facebook;

import structure.TreeNode;

/* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 * */

public class SuccessorBST {
	public TreeNode Successor(TreeNode root, TreeNode p) {
		if (root == null) return null;
		if (root.val <= p.val) {
			return Successor(root.right, p);
		} else {
			TreeNode left = Successor(root.left, p);
			return (left != null) ? left : root;
		}
	}
	
	 public TreeNode Precessor(TreeNode root, TreeNode p) {
		 if (root == null) return null;
		 if (root.val >= p.val) {
			 return Precessor(root.left, p);
		 } else {
			 TreeNode right = Precessor(root.right, p);
			 return (right != null) ? right : root;
		 }
	 }
}
