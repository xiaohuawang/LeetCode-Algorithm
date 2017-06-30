package lc;

public class LeetCode100SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null) {
			return true;
		}

		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}

	public static void main(String[] args) {

		LeetCode100SameTree lc = new LeetCode100SameTree();
		BST btf = new BST();
		// btf.addNode(10);
		// btf.addNode(7);
		// btf.addNode(15);
		// btf.addNode(1);
		System.out.println(btf.root);
		// System.out.println(btf.root.left.val);
		// System.out.println(btf.root.right.val);
		// System.out.println(btf.root.left.left.val);

		TreeNode root1 = new TreeNode(1);
		// TreeNode root1 = new TreeNode(10);
		// root1.left = new TreeNode(7);
		// root1.right = new TreeNode(15);
		// root1.left.left = new TreeNode(1);

		boolean res = lc.isSameTree(btf.root, root1);
		 System.out.println("res= " + res);

	}
}
