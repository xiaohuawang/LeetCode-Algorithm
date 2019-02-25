package lc_ea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Leetcode46 {

	Set<String> set = new HashSet();

	public List<List<Integer>> permute(int[] nums) {

		int length = nums.length;
		List<List<Integer>> res = new ArrayList();
		permuteHelper(nums, length, 0);
		// System.out.println(set);
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			List<Integer> list = new ArrayList();
			String integer_from_set = (String) iter.next();
			for (int i = 0; i < nums.length; i++) {
				if (integer_from_set.substring(i, i + 1).contains("-")) {
					list.add(Integer.valueOf(integer_from_set.substring(i, i + 2)));
				} else
					list.add(Integer.valueOf(integer_from_set.substring(i, i + 1)));
			}
			res.add(list);
		}
		System.out.println("res_list.size= " + res.size());
		return res;
	}

	private void permuteHelper(int[] nums, int length, int starting_index) {
		// TODO Auto-generated method stub
		if (starting_index == length)
			return;
		for (int i = starting_index; i < nums.length; i++) {
			// System.out.println("i=" + i);
			nums = swap(nums, starting_index, i);
			// add the changed num to set
			String num_changed = form_int_array(nums);
			System.out.println("starting_index= " + starting_index);
			System.out.println("number changed= " + num_changed);
			System.out.println();
			set.add(num_changed);
			// explore the next loop
			permuteHelper(nums, length, ++starting_index);
			// swapback
			starting_index--;
			nums = swap(nums, starting_index, i);
		}
	}

	private String form_int_array(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		return sb.toString();
	}

	private int[] swap(int nums[], int starting_index, int i) {

		int temp_int = nums[i];
		nums[i] = nums[starting_index];
		nums[starting_index] = temp_int;
		return nums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode46 lc = new Leetcode46();
		int nums[] = { 0, -1, 1 };
		// int nums[] = { 1, 2, 3 };
		List<List<Integer>> res = lc.permute(nums);
		for (int i = 0; i < res.size(); i++) {
			System.out.println("res= " + res.get(i));
		}
	}

}
