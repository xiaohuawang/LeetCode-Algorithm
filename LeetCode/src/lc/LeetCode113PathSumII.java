package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Given a binary tree and a sum, find all root-to-leaf paths where 
//each path's sum equals the given sum.

//Given the below binary tree and sum = 22,
//				 5
//				/ \
//			   4   8
//			 / 	  / \
//			11   13  4
//		   / \      / \
//		  7   2    5   1
//return
//		[
// 			[5,4,11,2],
// 			[5,8,4,5]
//		]

public class LeetCode113PathSumII {

	List<Integer> list=new ArrayList<Integer>();
	List<List<Integer>> res=new ArrayList<List<Integer>>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		
		System.out.println("come");
		Helper(root,sum);
		return res;
	}
	
	

	private void Helper(TreeNode root, int sum) {
		
		if(root==null){
//			list=new ArrayList<Integer>();
			return;
		}
		if(root.left==null&&root.right==null&&root.val==sum){
//			list=new ArrayList<Integer>();
			System.out.println("             we got it");
			List<Integer> temp=new ArrayList<Integer>(list);
			temp.add(root.val);
			res.add(temp);
//			System.out.println("res(0)= "+res.get(0));
//			return kejia kebujia
//			return; 
		}
		
		list.add(root.val);
		System.out.println(list);
		Helper(root.left,sum-root.val);
		Helper(root.right,sum-root.val);
		list.remove(list.size()-1);
		
	}



	public static void main(String[] args) {
		
		LeetCode113PathSumII lc=new LeetCode113PathSumII();
		
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.left.left=new TreeNode(11);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4);
		root.left.left.left=new TreeNode(7);
		root.left.left.right=new TreeNode(2);
		root.right.right.right=new TreeNode(1);
		root.right.right.left=new TreeNode(5);
		
		Scanner sc=new Scanner(System.in);
		int target=sc.nextInt();
		lc.pathSum(root, target);
			
		System.out.println(lc.res.size());
		for(int i=0;i<lc.res.size();i++){
			System.out.println(lc.res.get(i));
		}
	}
}












