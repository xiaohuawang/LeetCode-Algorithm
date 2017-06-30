package lc;

import java.util.ArrayList;
import java.util.List;

public class LeetCode098ValidBST {

	List<Integer> resList = new ArrayList<Integer>();

	public boolean isValidBST(TreeNode root) {

//		 System.out.println("root.val= "+root.val);
		helper(root);

		for (int i = 0; i < resList.size(); i++) {
			System.out.print(resList.get(i) + " ");
		}

		return check(resList);
	}

	private void helper(TreeNode root) {

		if (root == null)
			return;
		helper(root.left);
		resList.add(root.val);
		helper(root.right);
	}

	private boolean check(List<Integer> resList) {

		for (int i = 0; i < resList.size() - 1; i++) {
			if (resList.get(i) >= resList.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	// public void inOrder(TreeNode root){
	//
	// if(root==null)
	// return;
	//
	// inOrder(root.left);
	// System.out.print(root.val+" ");
	// inOrder(root.right);
	//
	// }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode098ValidBST lc = new LeetCode098ValidBST();
//		BST bst = new BST();
//
//		bst.addNode(9);
//		bst.addNode(7);
//		bst.addNode(18);
//		bst.addNode(3);
//		bst.addNode(8);

//		lc.inOrder(bst.root);
		TreeNode root=new TreeNode(11);
		root.left=new TreeNode(7);
		root.right=new TreeNode(18);
		root.right.left=new TreeNode(19);
		boolean res = lc.isValidBST(root);
		System.out.println();
		System.out.println("res= " + res);
	}

}
