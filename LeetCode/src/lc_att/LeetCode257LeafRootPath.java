package lc_att;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return all root-to-leaf paths.
//
//For example, given the following binary tree:
//
//  	 1
//	   /   \
//	  2     3
// 	   \
//  	5
//All root-to-leaf paths are:
//
//["1->2->5", "1->3"]

public class LeetCode257LeafRootPath {

//	List<List<Integer>> res=new ArrayList<List<Integer>>();
//	
//	public List<List<Integer>> binaryTreePaths(TreeNode root) {
//		
//		List<Integer> list=new ArrayList<Integer>();
//		Helper(root,list);
//		
//		return res;
//	}
//
//	
//	private void Helper(TreeNode root,List<Integer> list) {
//		
//		if(root==null){
//			System.out.println("come");
//			res.add(list);
//			System.out.println("list before= "+list);
//			list=new ArrayList<Integer>();
//			System.out.println("list after= "+list);
//			return;
//		}
//		
////		System.out.println(root.val);
//		System.out.println("list.size= "+list.size());
//		list.add(root.val);
//
//		Helper(root.left,list);
//		Helper(root.right,list);
////		list.remove(list.size()-1);
//		
//	}
	
	
	public List<String> binaryTreePaths(TreeNode root) {
	    ArrayList<String> finalResult = new ArrayList<String>();
	 
	    if(root==null)
	        return finalResult;
	 
	    ArrayList<String> curr = new ArrayList<String>();
	    ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	 
	    dfs(root, results, curr);
	 
	    System.out.println("result.size= "+results.size());
	    for(ArrayList<String> al : results){
	        StringBuilder sb = new StringBuilder();
	        sb.append(al.get(0));
	        for(int i=1; i<al.size();i++){
	            sb.append("->"+al.get(i));
	        }
	 
	        finalResult.add(sb.toString());
	    }
	 
	    return finalResult;
	}
	 
	public void dfs(TreeNode root, ArrayList<ArrayList<String>> list, ArrayList<String> curr){
	    curr.add(String.valueOf(root.val));
	 
	    if(root.left==null && root.right==null){
	        list.add(curr);
	        return;
	    }
	 
	    if(root.left!=null){
	        ArrayList<String> temp = new ArrayList<String>(curr);
	        dfs(root.left, list, temp);
	    }
	 
	    if(root.right!=null){
	        ArrayList<String> temp = new ArrayList<String>(curr);
	        dfs(root.right, list, temp);
	    } 
	}


	private void inOrderTraverse(TreeNode root) {
		if(root==null)
			return;
		
		inOrderTraverse(root.left);
		System.out.print(root.val+" ");
		inOrderTraverse(root.right);
	}
	
	public static void main(String[] args) {
		
		LeetCode257LeafRootPath lc=new LeetCode257LeafRootPath();
		BST bst=new BST();
		bst.addNode(10);
		bst.addNode(3);
		bst.addNode(19);
		bst.addNode(1);
		bst.addNode(5);
		bst.addNode(13);
		bst.addNode(25);
		
		List<String> finalResult=lc.binaryTreePaths(bst.root);
		
//		System.out.println(lc.res.get(0));
		for(int i=0;i<finalResult.size();i++){
			System.out.println(finalResult);
		}
		
//		lc.inOrderTraverse(bst.root);
	}

}
