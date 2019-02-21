package lc_ea;

public class Leetcode985 {

	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {

		int result[] = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int chanage = queries[i][0];
			A[queries[i][1]] += chanage;
			result[i] = getSumEven(A);
			printHelper(A);
		}
		return result;
	}

	private static int getSumEven(int[] arr) {
		int sum = 0;
		for (Integer i : arr) {
			if (i % 2 == 0)
				sum += i;
		}
		return sum;
	}

	private static void printHelper(int[] arr) {
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 1, 2, 3, 4 };
		int queries[][] = { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } };
		int res[] = Leetcode985.sumEvenAfterQueries(A, queries);
		printHelper(res);
	}

}
