package lc_ea;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import node.TreeNode;

public class Leetcode958 {

	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode currentNode = queue.poll();
				list.add(currentNode.val);
				if (currentNode.left != null)
					queue.add(currentNode.left);
				if (currentNode.right != null)
					queue.add(currentNode.right);
			}
		}

		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > (i + 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		Leetcode958 lc = new Leetcode958();
		boolean res = lc.isCompleteTree(root);
		System.out.println(res);
	}

}
