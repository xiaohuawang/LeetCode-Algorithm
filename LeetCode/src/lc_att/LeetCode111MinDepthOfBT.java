package lc_att;

import java.util.LinkedList;

public class LeetCode111MinDepthOfBT {

	int depth = 0;

	// public int getDepth(TreeNode root) {
	//
	// int res=Helper(root);
	// return res;
	// }
	//
	// private int Helper(TreeNode root) {
	//
	// if(root==null)
	// return 0;
	//
	// int lDepth = Helper(root.left);
	// int rDepth = Helper(root.right);
	//
	// System.out.println("l= "+lDepth +" r= "+rDepth);
	// /* use the larger one */
	// int depth=Math.max(lDepth,rDepth)+1;
	// return depth;
	// }

	// public void postOrder(TreeNode root){
	//
	// if(root==null){
	// return;
	// }
	//
	// postOrder(root.left);
	// postOrder(root.right);
	// System.out.print(root.val+" ");
	//
	// }

	// public int minDepth(TreeNode root) {
	//
	// if (root == null)
	// return 0;
	// if (root.left == null && root.right == null)
	// return 1;
	// int res = Helper(root);
	//
	// return res;
	// }

	// private int Helper(TreeNode root) {
	//
	// if(root==null){
	// return 0;
	// }
	//
	// int leftd=Helper(root.left);
	// int rightd=Helper(root.right);
	//
	// System.out.println("root.val= "+root.val+" l= "+leftd +" r= "+rightd);
	//
	// int depth=Math.min(leftd, rightd)+1;
	//
	// return depth;
	// }

	public int minDepth(TreeNode root) {
		
		if(root==null){
			return 0;
		}
		//the min level of the tree
		int level=1;
		//same of the count. everytime dequeue, len-1, when len=0, which means all the number from that level has been dequeue. 
		// and we can go to the next level..
		int len=1;
		//the count of the element in queue. the max of the count should be the total number of the cell on the same level
		int count=0;
		LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			
			TreeNode curr=queue.poll();
			len--;
			
			if(curr.left==null&&curr.right==null){
				System.out.println("end");
				return level;
			}
			if(curr.left!=null){
				queue.add(curr.left);
				count++;
			}
			if(curr.right!=null){
				queue.add(curr.right);
				count++;
			}
			if(len==0){
				level++;
				len=count;
				count=0;
			}
		}
		
		System.out.println("should never apper");
		return 0;
	}

	    public int minDepth1(TreeNode root) {
	        int level = 0;
	        if(root == null) return level;
	        
	        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	        int curNum = 0;
	        int lastNum = 1;

	        queue.offer(root);
	        level = 1;
	        while(!queue.isEmpty()){
	            TreeNode cur = queue.poll();
	            lastNum--;
	            if(cur.left==null && cur.right==null){  //判断是�?�返回在这里
	                return level;
	            }
	            if(cur.left!=null){
	                queue.add(cur.left);
	                curNum++;
	            }
	            if(cur.right!=null){
	                queue.add(cur.right);
	                curNum++;
	            }
	            if(lastNum==0){
	                lastNum = curNum;
	                curNum = 0;
	                level++;
	            }
	        }
	        return 0;
	    }

	
	public static void main(String[] args) {

		// 1,2
		TreeNode root = new TreeNode(1);
//		root.right = new TreeNode(2);
		root.left = new TreeNode(4);
//		root.left.left=new TreeNode(10);
//		root.left.right=new TreeNode(7);
//		root.right.right=new TreeNode(15);
//		root.right.left=new TreeNode(6);

		LeetCode111MinDepthOfBT lc = new LeetCode111MinDepthOfBT();

//		List<List<Integer>> res = lc.getDepth(root);
//		System.out.println("res.size= " + res.size());
//		for (int i = 0; i < res.size(); i++) {
//			System.out.println(res.get(i));
//		}
		
		 int res=lc.minDepth(root);
//		 int res=lc.minDepth(root);
		 System.out.println("res= "+res);
		// System.err.println("res= "+res);
	}

}
