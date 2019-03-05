package lc_ea;

public class Leetcode485 {

	public int findMaxConsecutiveOnes(int[] nums) {

		if (nums.length == 0)
			return 0;
		int max_len = 0;
		int cur_len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				cur_len++;
				if (cur_len > max_len)
					max_len = cur_len;
			} else {
				cur_len = 0;
			}
		}

		return max_len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode485 lc = new Leetcode485();
		int nums[] = { 1, 1, 0, 1, 1, 1 };
		int res = lc.findMaxConsecutiveOnes(nums);
		System.out.println("res= " + res);
	}

}
