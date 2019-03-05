package lc_ea;

// nice solution
import lc_att.TreeNode;

//     6
//   /   \
//  3     5
//  \    / 
//   2  0   
//    \
//     1
// int nums[] = { 3, 2, 1, 6, 0, 5 };

public class Leetcode654 {

	public TreeNode constructMaximumBinaryTree(int[] nums) {

		TreeNode root = Helper(nums);
		System.out.println("val= " + root.val);
		return root;
	}

	private TreeNode Helper(int[] nums) {
		// TODO Auto-generated method stub
		if (nums.length == 0)
			return null;

		int root_value_index = getMaxValueIndex(nums);
//		System.out.println("index= " + root_value_index);
		TreeNode root = new TreeNode(nums[root_value_index]);

		int result[][] = spilit_array(nums, root_value_index);
		int nums_l[] = result[0];
		int nums_r[] = result[1];

//		System.out.println("nums_l.len= " + nums_l.length);
//		System.out.println("nums_r.len= " + nums_r.length);

		root.left = Helper(nums_l);
		root.right = Helper(nums_r);
		return root;
	}

	private int[][] spilit_array(int[] nums, int index) {
		// TODO Auto-generated method stub
		int len = nums.length;
		int result[][] = new int[2][];
		int a[] = new int[index];
		int b[] = new int[len - index - 1];

		for (int i = 0; i < len; i++) {
			if (i < index)
				a[i] = nums[i];
			else if (i > index)
				b[i - index - 1] = nums[i];
		}

		result[0] = a;
		result[1] = b;

		return result;
	}

	private int getMaxValueIndex(int[] nums) {

		int max_value_index = -1;
		int max_value = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max_value) {
				max_value = nums[i];
				max_value_index = i;
			}
		}
		return max_value_index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode654 lc = new Leetcode654();
		int nums[] = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = lc.constructMaximumBinaryTree(nums);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.left.right.right.val);
	}

}
