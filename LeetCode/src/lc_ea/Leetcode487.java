package lc_ea;

//Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
//
//Example 1:
//Input: [1,0,1,1,0]
//Output: 4
//Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
//    After flipping, the maximum number of consecutive 1s is 4.
//Note:
//
//The input array will only contain 0 and 1.
//The length of input array is a positive integer and will not exceed 10,000
//Follow up:
//What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?

public class Leetcode487 {

	public int findMaxConsecutiveOnes(int[] nums) {

		// cnt is the current 1 numbers
		int cur = 0;
		// cur is the previous 1 numbers
		int pre = 0;
		int max = 0;
		int count_1 = 0;

		for (int i = 0; i < nums.length; i++) {

			// if the current num = 1
			if (nums[i] == 1) {
				// count all the 1s
				count_1++;
				// if this is not last 1 in the array
				if (i != nums.length - 1)
					// add the count 1 number
					cur++;
				// if this is the last 1 in the array
				else {
					// if the count_1==nums.len, all the number in the array is 1
					if (count_1 == nums.length)
						max = Math.max(max, pre + cur + 1);
					else
						// if not all the number in the array is 1
						max = Math.max(max, pre + cur + 2);
				}
				// if the current number is not 1 (the current number is 0)
			} else {
				System.out.println("cur= " + pre);
				System.out.println("cnt= " + cur);
				System.out.println();
				// if the pre (previous 1) + cnt(current 1)+1 (the only 0 between the previous
				// and the current)
				if (pre + cur + 1 > max) {
					// update the max
					max = pre + cur + 1;
				}
				// since this the 0, we will set pre to the current value
				pre = cur;
				// and we will update the current value = 0
				cur = 0;
			}
		}

		System.out.println("max= " + max);
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode487 lc = new Leetcode487();
//		int nums[] = new int[] { 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0 };
//		int nums[] = new int[] { 1, 1, 0, 1 };
//		int nums[] = new int[] { 1, 0, 0, 1 };
//		int nums[] = new int[] { 0, 0 };
		int nums[] = new int[] { 1, 1 };

		lc.findMaxConsecutiveOnes(nums);
	}

}
