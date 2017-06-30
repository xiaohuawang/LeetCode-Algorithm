package lc;

public class Contest2 {

	TreeNode res;
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		int level = 1;
		res=root;
		Helper(res, v, d, level);
		return res;
	}

	private void Helper(TreeNode res, int v, int d, int level) {
		// TODO Auto-generated method stub
		

		if (level == d-1) {
			System.out.println("come");
			TreeNode tempL = res.left;
			TreeNode tempR = res.right;
			res.left = new TreeNode(v);
			res.left.left = tempL;
			res.right = new TreeNode(v);
			res.right.right = tempR;
			System.out.println("res.val= "+res.val);
		}

		if (res == null)
			return ;
		
		Helper(res.left, v, d, level + 1);
		Helper(res.right, v, d, level + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contest2 contest = new Contest2();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right=new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left=new TreeNode(5);

		TreeNode res=contest.addOneRow(root, 1, 2);
		System.out.println(res.val);
		System.out.println(res.left.val);
		System.out.println(res.right.val);
		System.out.println(res.left.left.val);
	}

}
