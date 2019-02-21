package lc_att;

import java.util.Stack;

public class LeetCode114FlattenBT {

	
	private TreeNode lastNode = null;
	
//	public void preOrder(TreeNode root) {
//
//	}

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		if (lastNode != null) {
			lastNode.right = root;
			lastNode.left = null;
		}

		// PreOrder
		lastNode = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);

	}

	// public void stackInOrder(TreeNode root) {
	// Stack<TreeNode> stack=new Stack<TreeNode>();
	// stack.push(root);
	//
	// while(stack!=null){
	// TreeNode temp=stack.pop();
	// System.out.println(temp.val);
	// stack.push(temp.left);
	// stack.push(temp.right);
	// }
	// }

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.println(root.val);
		inOrder(root.right);
	}

	public static void main(String[] args) {

		LeetCode114FlattenBT lc = new LeetCode114FlattenBT();

		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(5);
		 root.left.left = new TreeNode(3);
		 root.left.right = new TreeNode(4);
		 root.right.right = new TreeNode(6);
//		TreeNode root = new TreeNode(10);
//		root.left = new TreeNode(5);
//		root.right = new TreeNode(15);
//		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(7);
//		root.left.right = new TreeNode(13);
//		root.right.right = new TreeNode(20);
		
		lc.flatten(root);
		System.out.println(root.val);
		System.out.println(root.right.val);
		System.out.println(root.right.right.val);

		// lc.preOrder(root);
		// lc.stackInOrder(root);
		// lc.inOrder(root);
	}

}
