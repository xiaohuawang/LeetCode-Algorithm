package lc;

public class LeetCode623 {

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		TreeNode res=root;
		int level=2;
		
		Helper(root,v,d,level);
		return res;
	}

	private void Helper(TreeNode root, int v, int d, int level) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		if(level==d){
			TreeNode tempL=root.left;
			TreeNode tempR=root.right;
			root.left=new TreeNode(v);
			root.right=new TreeNode(v);
			root.left.left=tempL;
			root.right.right=tempR;
		}
		
		Helper(root.left,v,d,level+1);
		Helper(root.right,v,d,level+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LeetCode623 lc=new LeetCode623();
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		
		TreeNode res=lc.addOneRow(root, 1, 2);
		System.out.println(res.left.val);
		System.out.println(res.right.val);
	}

}
