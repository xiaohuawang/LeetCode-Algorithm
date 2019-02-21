package lc_ea;

import java.util.ArrayList;
import java.util.List;

public class Leetcode978 {

	public int maxTurbulenceSize(int[] A) {

		if (A.length == 1)
			return 1;
		List<Integer> bianhua = new ArrayList();
		int pre = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > pre)
				bianhua.add(1);
			else if (A[i] < pre)
				bianhua.add(-1);
			else
				bianhua.add(0);
			pre = A[i];
		}
		System.out.println(bianhua);
		int tempLen = 1;
		int maxLen = 1;
		int zhiqian = bianhua.get(0);

		for (int i = 0; i < bianhua.size(); i++) {
			if (zhiqian * bianhua.get(i) == 0) {
				tempLen = 1;
				zhiqian = bianhua.get(i);
			} else if (zhiqian * bianhua.get(i) == 1) {
				tempLen = 0;
				zhiqian = bianhua.get(i);
			} else if (zhiqian * bianhua.get(i) == -1) {
				tempLen++;
				zhiqian = bianhua.get(i);
			}
			maxLen = Math.max(tempLen, maxLen);
			System.out.println(tempLen);
		}
		System.out.println("jieguo= " + maxLen);
		return (maxLen + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int A[] = { 9, 4, 2, 10, 7, 8, 8, 1, 9 };
//		int A[] = { 100 };
		int A[] = { 0, 1, 1, 0, 1, 0, 1, 1, 0, 0 };
		Leetcode978 lc = new Leetcode978();
		int res = lc.maxTurbulenceSize(A);
		System.out.println("res= " + res);
	}

}
