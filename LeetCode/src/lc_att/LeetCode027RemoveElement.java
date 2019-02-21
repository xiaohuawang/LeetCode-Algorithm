package lc_att;

import java.util.Scanner;

public class LeetCode027RemoveElement {
	
	int nums[] = { 3, 2, 2, 3 };
	
	public int removeElement(int[] nums, int val) {
		
//		System.out.println("come");
		int len=nums.length;
		int store[]=new int[len];
		for(int i=0,j=0;i<nums.length;i++){
			if(nums[i]!=val){
				nums[j]=nums[i];
				j++;
			}else{
				len--;
			}
		}
		
		System.out.println("answer");
		for(int i=0;i<len;i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		System.out.println("end");
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode027RemoveElement lc=new LeetCode027RemoveElement();
		
		
		Scanner sc=new Scanner(System.in);
		int val=sc.nextInt();
		int res=lc.removeElement(lc.nums, val);
		System.out.println("res= "+res);
//		for(int temp: lc.nums){
//			System.out.println(lc.nums[temp]);
//		}
	}

}
