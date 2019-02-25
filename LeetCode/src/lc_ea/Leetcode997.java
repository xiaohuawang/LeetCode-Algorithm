package lc_ea;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Leetcode997 {

	public int findJudge(int N, int[][] trust) {

		if (N == 1 && trust.length == 0)
			return 1;
		int judge_index = -1;
		Map<Integer, Integer> map = new HashMap();
		System.out.println("start");
		for (int i = 0; i < trust.length; i++) {
			int trust_person = trust[i][1];
			map.put(trust_person, map.getOrDefault(trust_person, 0) + 1);
			System.out.println(trust[i][1]);
		}
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getValue().equals(N - 1))
				judge_index = (int) pair.getKey();
		}

		for (int i = 0; i < trust.length; i++) {
			if (trust[i][0] == judge_index)
				return -1;
		}

		return judge_index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int trust[][] = { { 1, 2 } };
		int trust[][] = {};
		int N = 1;
		Leetcode997 lc = new Leetcode997();
		int res = lc.findJudge(N, trust);
		System.out.println("res= " + res);
	}

}
