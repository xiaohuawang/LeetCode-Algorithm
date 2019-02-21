package lc_ea;

import node.TreeNode;

//993. Cousins in Binary Tree

//User Accepted: 2327
//User Tried: 2533
//Total Accepted: 2384
//Total Submissions: 4430
//Difficulty: Easy
//In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
//Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
//We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
//Return true if and only if the nodes corresponding to the values x and y are cousins.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4], x = 4, y = 3
//Output: false
//Example 2:
//
//
//Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
//Output: true
//Example 3:
//
//
//
//Input: root = [1,2,3,null,4], x = 2, y = 3
//Output: false

public class Leetcode993 {

	public boolean isCousins(TreeNode root, int x, int y) {
		int x_level = 0;
		int y_level = 0;
		x_level = getLevel(root, x, x_level);
		y_level = getLevel(root, y, y_level);

		System.out.println("x_l= " + x_level);
		System.out.println("y_l= " + y_level);
		return false;
	}

	private int getLevel(TreeNode root, int x, int level) {
//		// TODO Auto-generated method stub
//
//		if (root.val == x)
//			return level;
//
//		if (root.left != null) {
//			level++;
//			int next_level = getLevel(root.left, x, level);
//			return next_level;
//		}
//
//		if (root.right != null) {
//			level++;
//			int next_level = getLevel(root.right, x, level);
//			return next_level;
//		}

//		int downlevel = getLevel(root.left, x, level + 1);
//		if (downlevel != 0)
//			return downlevel;
//
//		downlevel = getLevel(root.right, x, level + 1);
//		return downlevel;
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode993 lc = new Leetcode993();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		boolean res = lc.isCousins(root, 5, 4);
	}

}
