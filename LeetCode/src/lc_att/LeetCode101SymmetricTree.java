package lc_att;

public class LeetCode101SymmetricTree {

	TreeNode root;
	public boolean isSymmetric(TreeNode root) {

		if(root==null)
			return true;
//		TreeNode rootL=root;
//		TreeNode rootR=root;
		return helper(root.left,root.right);	
	}
	
	public boolean helper(TreeNode leftNode, TreeNode rightNode) {
		
		if(leftNode==null&&rightNode==null){
			return true;
		}else if(leftNode==null||rightNode==null){
			System.out.println("1");
			return false;
		}
		
		if (leftNode.val != rightNode.val) {
			System.out.println("2");
			return false;
		}

		return (helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left));
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode101SymmetricTree lc=new LeetCode101SymmetricTree();
//		lc.createBST(10);
//		lc.createBST(7);
//		lc.createBST(3);
//		lc.createBST(12);
//		System.out.println(lc.root.val);
//		System.out.println(lc.root.left.val);
//		System.out.println(lc.root.left.left.val);
//		System.out.println(lc.root.right.val);
		
		TreeNode node0=new TreeNode(10);
		TreeNode node1=new TreeNode(7);
		TreeNode node2=new TreeNode(7);
		TreeNode node3=new TreeNode(5);
		TreeNode node4=new TreeNode(5);
//		TreeNode node5=null;
		TreeNode node5=new TreeNode(3);
		TreeNode node6=new TreeNode(3);
//		TreeNode node6=null;

		lc.root=node0;
		lc.root.left=node1;
		lc.root.right=node2;
		lc.root.left.left=node3;
		lc.root.right.right=node4;
		lc.root.left.right=node5;
		lc.root.right.left=node6;
//		lc.root=null;
		
		boolean res=lc.isSymmetric(lc.root);
		System.out.println("res= "+res);
	}

}
