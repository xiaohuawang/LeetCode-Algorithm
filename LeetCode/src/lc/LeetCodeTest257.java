package lc;

import java.util.ArrayList;
import java.util.List;


public class LeetCodeTest257 {

//	public List<List<Integer>> binaryTreePaths(TreeNode root) {
//
//		List<List<Integer>> res = new ArrayList<List<Integer>>();
//		
//		List<Integer> list = new ArrayList<Integer>();
//		Helper(root, list,res);
//
//		System.out.println(res);
//		return res;
//	}
//
//
//
	
	List<List<Integer>> res=new ArrayList<List<Integer>>();
	List<String> finalResult=new ArrayList<String>();
	
	public List<String> binaryTreePaths(TreeNode root) {
		
		int height=0;
		List<Integer> list=new ArrayList<Integer>();
		Helper(root,list,height);
		
		System.out.println("temp");
		for(List<Integer> temp1:res){
			StringBuilder sb=new StringBuilder();
			sb.append(temp1.get(0));
			for(int i=1;i<temp1.size();i++){
				sb.append("->"+temp1.get(i));
			}
			finalResult.add(sb.toString());
		}
//		System.out.println(finalResult);
		return finalResult;
	}
	
	private void Helper(TreeNode root, List<Integer> list, int height) {
		list.add(root.val);
		if(root.left==null&&root.right==null){
			res.add(list);
			return;
		}
		if(root.left!=null){
			List<Integer> temp=new ArrayList<Integer>(list);
			Helper(root.left,temp,height);
		}
		if(root.right!=null){
			List<Integer> temp=new ArrayList<Integer>(list);
			Helper(root.right,temp,height);
		}
	}
	


	
//	public void Helper(TreeNode root,List<Integer> list) {
//		
//		list.add(root.val);
//		if(root.left==null&&root.right==null){
//			System.out.println("come");
//			res.add(list);
//		}
//		
//		if(root.left!=null){
//			
//			List<Integer> temp=new ArrayList<Integer>(list);
//			
//			Helper(root.left,temp);
//		}
//
//		if (root.right != null) {
//
//			List<Integer> temp = new ArrayList<Integer>(list);
////			temp.add(root.val);
//			Helper(root.right, temp);
//		}
////		list.remove(list.size()-1);
//		
//	}
	
	


//	private void Helper(TreeNode root, List<Integer> list) {
//		
//		if(root==null){
//			res.add(list);
//			return;
//		}
//		System.out.println("root.val= "+root.val);
//		list.add(root.val);
//		List<Integer> temp=new ArrayList<Integer>(list);
//		Helper(root.left,temp);
//		temp=new ArrayList<Integer>(list);
//		Helper(root.right,temp);
//	}

	public void preOrder(TreeNode root){
		
		System.out.println(root.val);
		if(root.left==null&&root.right==null){
			return;
		}
		if(root.left!=null){
			preOrder(root.left);
		}
		if(root.right!=null){
			preOrder(root.right);
		}
	}
	
	public int sumNumbers(TreeNode root) {
		
		return 0;
	}

//	private int getHeight(TreeNode root) {
//		// TODO Auto-generated method stub
//		int height=0;
//		return Height(root,height);
//		
//	}
	

	public static void main(String[] args) {

		BST bst = new BST();
//		bst.addNode(10);
//		bst.addNode(3);
//		bst.addNode(19);
//		bst.addNode(1);
//		bst.addNode(5);
//		bst.addNode(13);
//		bst.addNode(25);
		
		bst.addNode(6);
		bst.addNode(3);
		bst.addNode(1);
		bst.addNode(4);
		bst.addNode(8);
		bst.addNode(7);
		bst.addNode(9);
		
		LeetCodeTest257 lc=new LeetCodeTest257();
//		lc.binaryTreePaths(bst.root);
		
//		lc.preOrder(bst.root);
		List<String> res=lc.binaryTreePaths(bst.root);
//		lc.getHeight(bst.root);
		System.out.println(res);
//		System.out.println(res.size());
//		System.out.println(res);
	}


}
