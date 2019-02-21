package lc_ea;

import java.util.HashMap;
import java.util.Map;

public class Leetcode974 {

	public int subarraysDivByK(int[] A, int K) {

		System.out.println("test");
		int result = 0;
		int sum = 1000 * K;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			int mod = sum % K;
			if (map.containsKey(mod)) {
				map.put(mod, map.get(mod) + 1);
			} else {
				map.put(mod, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() == 0) {
				result += entry.getValue() * (entry.getValue() + 1) / 2;
			} else {
				result += entry.getValue() * (entry.getValue() - 1) / 2;
			}
		}
		System.out.println("map= " + map);
		return result;
	}

	public static void main(String[] args) {
		Leetcode974 lc = new Leetcode974();
		int A[] = { 4, 5, 0, -2, -3, 1 };
//		int A[] = { -1, 2, 9 };
		int K = 5;
		int result = lc.subarraysDivByK(A, K);
		System.out.println(result);
	}
}
