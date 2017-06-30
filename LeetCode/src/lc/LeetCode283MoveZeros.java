package lc;

public class LeetCode283MoveZeros {
	
	public void moveZeroes(int[] nums) {
		int i = 0;
		int j = 0;

		while (j < nums.length) {
			if (nums[j] == 0) {
				j++;
			} else {
				nums[i] = nums[j];
				i++;
				j++;
			}
		}

		while (i < nums.length) {
			nums[i] = 0;
			i++;
		}
		for (int lol : nums) {
			System.out.print(lol + " ");
		}
	}
	
	public static void main(String[] args) {
		
		LeetCode283MoveZeros lc=new LeetCode283MoveZeros();
		int nums[]= {0, 1, 0, 3, 12};
		lc.moveZeroes(nums);
	}
}	
