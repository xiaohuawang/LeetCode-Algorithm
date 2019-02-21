package lc_ea;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static int test(int A[], int K) {
		int sum = 0;
		int plus = K;
		while (plus < 10000) {
			plus += K;
		}
		System.out.println("plus= " + plus);

		Map<Integer, Integer> rmap = new HashMap<>();
		for (int i = 0; i < A.length; ++i) {
			sum += A[i] + plus;
			System.out.println("sum= " + sum);
			int r = sum % K;
			int count = rmap.getOrDefault(r, 0);
			rmap.put(r, count + 1);
		}
		System.out.println(rmap);
		int total = 0;
		for (Map.Entry<Integer, Integer> entry : rmap.entrySet()) {
			int count = entry.getValue();
			if (entry.getKey() == 0) {
				total += (count + 1) * count / 2;
			} else {
				total += count * (count - 1) / 2;
			}
		}
		return total;
	}

	public static void main(String[] args) {
//		int A[] = { 4, 5, 0, -2, -3, 1 };
		int A[] = { -1, 2, 9 };
		int K = 2;
		Test.test(A, K);
	}
}
