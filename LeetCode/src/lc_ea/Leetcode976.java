package lc_ea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode976 {

	public int largestPerimeter(int[] A) {

		int result = 0;
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		List<Integer> list = new ArrayList();
		for (int i = 0; i < A.length; i++) {
			list.add(A[i]);
		}
		Collections.sort(list);
//		System.out.println(list);
		for (int i = list.size() - 1; i >= 2; i--) {
			a3 = list.get(i);
			a2 = list.get(i - 1);
			a1 = list.get(i - 2);
			if (a3 < a1 + a2) {
				result = a1 + a2 + a3;
				System.out.println(a1 + " " + a2 + " " + a3);
				return result;
			}
		}
//		System.out.println(list);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode976 lc = new Leetcode976();
//		int A[] = { 3, 2, 3, 4 };
//		int A[] = { 1, 2, 1 };
//		int A[] = { 2, 2, 1 };
		int A[] = { 3, 6, 2, 3 };
		int res = lc.largestPerimeter(A);
		System.out.println("res= " + res);
	}

}
