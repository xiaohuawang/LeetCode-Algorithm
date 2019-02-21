package lc_ea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Input: x = 3, y = 5, bound = 15
//Output: [2,4,6,8,10,14]

public class Leetcode970 {

	public List<Integer> powerfulIntegers(int x, int y, int bound) {

		Set<Integer> answerSet = new HashSet<Integer>();
		List<Integer> answerList = new ArrayList<Integer>();
		double res = 0;
		double itimes = Math.ceil(Math.pow(bound, 1.0 / x));
		double jtimes = Math.ceil(Math.pow(bound, 1.0 / y));

		System.out.println(itimes);
		System.out.println(jtimes);

		for (int i = 0; i < itimes + 1; i++) {
			for (int j = 0; j < jtimes + 1; j++) {
				System.out.println("i= " + i);
				System.out.println("j= " + j);
				res = Math.pow(x, i) + Math.pow(y, j);
				System.out.println("res= " + res);
				if (res <= bound) {
					answerSet.add((int) res);
				}
			}
			res = 0;
		}
		System.out.println(answerSet);
		answerList.addAll(answerSet);
		return answerList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3, y = 5;
		int bound = 15;
//		int x = 1, y = 1;
//		int bound = 3;
		Leetcode970 lc = new Leetcode970();
		lc.powerfulIntegers(x, y, bound);
	}

}
