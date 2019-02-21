package lc_ea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode984 {

	public String strWithout3a3b(int A, int B) {

		List<Integer> list = new ArrayList();
		list.add(A);
		list.add(B);
		StringBuilder sb = new StringBuilder();

		Collections.sort(list);
		int smaller = list.get(0);
		int larger = list.get(1);
		String smaller_s;
		String larger_s;

		if (smaller == A) {
			smaller_s = "a";
			larger_s = "b";
		} else {
			smaller_s = "b";
			larger_s = "a";
		}
//		System.out.println(smaller_s);
//		System.out.println(larger_s);
		int smaller_time = smaller;
		int larger_time = larger;

		while (larger_time > 0 || smaller_time > 0) {
			System.out.println(larger_time);
			System.out.println(smaller_time);
			if (larger_time >= 2 * smaller_time && larger_time >= 2 && smaller_time >= 1) {
				sb.append(larger_s);
				sb.append(larger_s);
				sb.append(smaller_s);
				larger_time -= 2;
				smaller_time -= 1;
			} else if (larger_time < 2 * smaller_time && larger_time >= 2 && smaller_time >= 2) {
				sb.append(larger_s);
				sb.append(larger_s);
				sb.append(smaller_s);
				sb.append(smaller_s);
				larger_time -= 2;
				smaller_time -= 2;
			} else if (larger_time >= 2 && smaller_time >= 2) {
				sb.append(larger_s);
				sb.append(larger_s);
				sb.append(smaller_s);
				sb.append(smaller_s);
				larger_time -= 2;
				smaller_time -= 2;
			} else if (larger_time >= 2 && smaller_time >= 1) {
				sb.append(larger_s);
				sb.append(larger_s);
				sb.append(smaller_s);
				larger_time -= 2;
				smaller_time--;
			} else if (larger_time >= 2 && smaller_time == 0) {
//				System.out.println("here");
				sb.append(larger_s);
				sb.append(larger_s);
				larger_time -= 2;
			} else if (larger_time == 1 && smaller_time >= 1) {
//				System.out.println("here");
				sb.append(larger_s);
				sb.append(smaller_s);
				larger_time--;
				smaller_time--;
			} else if (larger_time == 1 && smaller_time == 0) {
				sb.append(larger_s);
				larger_time--;
			} else if (larger_time == 0 && smaller_time >= 1) {
				sb.append(smaller_s);
				smaller_time--;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode984 lc = new Leetcode984();
		int A = 1;
		int B = 2;
		String res = lc.strWithout3a3b(A, B);
		System.out.println(res);
	}

}
