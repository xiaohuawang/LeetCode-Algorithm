package lc_att;

public class LeetCode198ProRobber {

	public int rob(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		
		int max[] = new int[nums.length];
		max[0] = nums[0];
		max[1] = Math.max(max[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
		}
		return max[nums.length - 1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode198ProRobber lc = new LeetCode198ProRobber();

		int nums[] = { 9, 0, 1, 10 };
		int res = lc.rob(nums);
		System.out.println("res=" + res);
	}

}
