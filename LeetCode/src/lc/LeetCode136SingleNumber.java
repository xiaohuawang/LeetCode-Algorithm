package lc;
//方法1：HashMap，起始value均为2，遇到一次value--，value == 0时清除key，看最后剩下的

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode136SingleNumber {

	public int singleNumber(int[] nums) {
		
		if(nums.length==1){
			return nums[0];
		}
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<nums.length;i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i])+1);
			}else{
				map.put(nums[i], 1);
			}
		}
		System.out.println(map);
		for(int i=0;i<nums.length;i++){
			if(map.get(nums[i])==1){
				return nums[i];
			}
		}
		return -11111;//not found
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={5,1,4,5,1,4,100,3,3};
		LeetCode136SingleNumber lc=new LeetCode136SingleNumber();
		int res=lc.singleNumber(nums);
		System.out.println("res= "+res);
	}

}
