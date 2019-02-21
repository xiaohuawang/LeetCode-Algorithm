package lc_att;

public class LeetCode098ValidateBST {

	//the method only work for the full bst
	public boolean isValidBSTF(TreeNode root) {
		
		if(root.left==null&&root.right==null){
			return true;
		}
//		if(root.left==null&&root.right.val>root.val){
//			isValidBST(root.right);
//		}
//		if(root.right==null&&root.left.val<root.val){
//			isValidBST(root.left);
//		}
		if(root.val<root.left.val){
			System.out.println("1");
			return false;
		}
		if(root.val>root.right.val){
			System.out.println("2");
			return false;
		}
		
		boolean ansleft=isValidBSTF(root.left);
		boolean ansright=isValidBSTF(root.right);
		return (ansleft&&ansright);
	}
	
	
//	public boolean isValidBST(TreeNode root){
//		
//		
//	}

	public static void main(String[] args) {
		
		LeetCode098ValidateBST lc=new LeetCode098ValidateBST();
		BST bst=new BST();
		bst.addNode(10);
		bst.addNode(7);
		bst.addNode(17);
		bst.addNode(6);
		bst.addNode(8);
		bst.addNode(11);
//		bst.addNode(20);
//		bst.root.right.right=new TreeNode(1);
		System.out.println(bst.root.val);
//		boolean res=lc.isValidBSTF(bst.root);
//		System.out.println("res= "+res);
		
	}
}
