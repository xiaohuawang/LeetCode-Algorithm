package lc;

import java.util.Arrays;

public class LeetCodeContest1 {

	public int maximumProduct(int[] nums) {

		int sum = 1;
		int count = 0;
		int temp[] = new int[nums.length];
		if (nums.length < 3) {
			return 0;
		}

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] < 0) {
				count++;
			}
			temp[i] = Math.abs(nums[i]);
			System.out.print(nums[i] + " ");
		}

		Arrays.sort(temp);
		Arrays.sort(nums);

		// if(count>=2&&Math.abs(nums[0])*Math.abs(nums[1])>Math.abs(nums[nums.length-1])*Math.abs(nums[nums.length-2])){
		// sum=nums[0]*nums[1]*nums[nums.length-1];
		// }else{
		// sum=nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1];
		//// for(int i=nums.length-3;i<nums.length;i++){
		//// sum=sum*nums[i];
		//// }
		// }

		if (count > 2 && nums[0] * nums[1] > nums[nums.length - 3] * nums[nums.length - 2]) {

			sum = nums[0] * nums[1] * nums[nums.length - 1];
		} else {
			System.out.println("come");
			sum = nums[0] * nums[1] * nums[nums.length - 1];
			// sum=nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1];
		}

		// System.out.println("sum= "+sum);
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCodeContest1 lc = new LeetCodeContest1();
		// int nums[]={-4,-3,-2,-1,60};
		int nums[] = { 722, 634, -504, -379, 163, -613, -842, -578, 750, 951, -158, 30, -238, -392, -487, -797, -157,
				-374, 999, -5, -521, -879, -858, 382, 626, 803, -347, 903, -205, 57, -342, 186, -736, 17, 83, 726, -960,
				343, -984, 937, -758, -122, 577, -595, -544, -559, 903, -183, 192, 825, 368, -674, 57, -959, 884, 29,
				-681, -339, 582, 969, -95, -455, -275, 205, -548, 79, 258, 35, 233, 203, 20, -936, 878, -868, -458,
				-882, 867, -664, -892, -687, 322, 844, -745, 447, -909, -586, 69, -88, 88, 445, -553, -666, 130, -640,
				-918, -7, -420, -368, 250, -786 };
		// int
		// nums[]={-710,-107,-851,657,-14,-859,278,-182,-749,718,-640,127,-930,-462,694,969,143,309,904,-651,160,451,-159,-316,844,-60,611,-169,-73,721,-902,338,-20,-890,-819,-644,107,404,150,-219,459,-324,-385,-118,-307,993,202,-147,62,-94,-976,-329,689,870,532,-686,371,-850,-186,87,878,989,-822,-350,-948,-412,161,-88,-509,836,-207,-60,771,516,-287,-366,-512,509,904,-459,683,-563,-766,-837,-333,93,893,303,908,532,-206,990,280,826,-13,115,-732,525,-939,-787};
		int res = lc.maximumProduct(nums);
		System.out.println();
		System.out.println(res);
	}

}
