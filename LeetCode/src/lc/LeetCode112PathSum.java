package lc;


//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
//all the values along the path equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//				 5
//				/ \
//			   4   8
//			  /   / \
//			11   13  4
//          / \       \
//         7   2       1

public class LeetCode112PathSum {

//	public boolean hasPathSum(TreeNode root, int sum) {
//		
//		if(root==null){
//			return false;
//		}
//		
//		if(root.left==null&&root.right==null){
//			return (root.val==sum);
//		}
//		
//		if(root.left==null||root.right==null){
//			if(root.left==null&&root.right.right==null&&root.right.left==null){
//				return (root.val+root.right.val==sum);
//			}else if(root.right==null&&root.left.left==null&&root.left.right==null){
//				return (root.val+root.left.val==sum);
//			}
//		}
//		
//		return helper(root,sum);
//	}
//	
//	public boolean helper(TreeNode root, int sum){
//		
//		if(root==null&&sum==0){
//			System.out.println("sum= "+sum+" we got it hahahaha");
//			return true;
//		}
//		else if(root==null){
//			System.out.println("sum= "+sum);
//			return false;
//		}
//		System.out.println(root.val+" sum= "+sum);
//		
//		boolean left=helper(root.left,sum-root.val);
//		boolean right=helper(root.right,sum-root.val);
//		
//		return (left||right);
//	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null && root.val == sum) {
			return true;
		}

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	
//	return false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LeetCode112PathSum lc=new LeetCode112PathSum();
		
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(4);
		root.right=new TreeNode(8);
		root.left.left=new TreeNode(11);
		root.right.left=new TreeNode(13);
		root.right.right=new TreeNode(4);
		root.left.left.left=new TreeNode(7);
		root.left.left.right=new TreeNode(2);
		root.right.right.right=new TreeNode(1);
		
		
		boolean res=lc.hasPathSum(root,22);
//		boolean res=lc.hasPathSum(root,99);
		System.out.println("res= "+res);
	}

}
