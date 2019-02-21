package lc_ea;

import node.TreeNode;

public class Leetcode776 {

	public TreeNode[] splitBST(TreeNode root, int V) {

		Helper(root, V);
		return null;
	}

	private void Helper(TreeNode root, int v) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (root.val >= v && root.left.val >= v) {

			// do nothing
			Helper(root.left, v);

		} else if (root.val >= v && root.left.val < v) {

		} else {

		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode776 lc = new Leetcode776();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		lc.splitBST(root, 2);
	}

}
