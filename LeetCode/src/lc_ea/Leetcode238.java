package lc_ea;

public class Leetcode238 {

	public static int[] productExceptSelf(int[] nums) {

		int res_l[] = new int[nums.length];
		int res_r[] = new int[nums.length];
		int res[] = new int[nums.length];

		res_l[0] = 1;
		res_r[nums.length - 1] = 1;

		for (int i = 1; i < nums.length; i++) {
			res_l[i] = res_l[i - 1] * nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			res_r[i] = res_r[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			res[i] = res_l[i] * res_r[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 1, 2, 3, 4 };
		int res[] = productExceptSelf(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(res[i]);
		}
	}

}
