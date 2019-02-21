package lc_att;

import java.util.ArrayList;
import java.util.List;

public class LC257Test {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> binaryTreePaths(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();
		Helper(root, list);

		return res;
	}

	private void Helper(TreeNode root, List<Integer> list) {

		if (root.left==null&&root.right==null) {
			System.out.println("come");
		
			res.add(list);
			System.out.println("res.size= "+res.size());
			System.out.println(res.get(0));
			list = new ArrayList<Integer>();
			System.out.println("list after= " + list);
			System.out.println();
			return;
		}

		// System.out.println(root.val);
		System.out.println("list.size= " + list.size());
		list.add(root.val);

		Helper(root.left, list);
		Helper(root.right, list);
		// list.remove(list.size()-1);

	}

	public static void main(String[] args) {

		LC257Test lc = new LC257Test();
		BST bst = new BST();
		bst.addNode(10);
		bst.addNode(3);
		bst.addNode(19);
		bst.addNode(1);
		bst.addNode(5);
		bst.addNode(13);
		bst.addNode(25);

		List<List<Integer>> finalResult = lc.binaryTreePaths(bst.root);
		
		System.out.println("res.size= "+finalResult.size());
		// System.out.println(lc.res.get(0));
		for (int i = 0; i < finalResult.size(); i++) {
			System.out.println(finalResult);
		}
	}

}
