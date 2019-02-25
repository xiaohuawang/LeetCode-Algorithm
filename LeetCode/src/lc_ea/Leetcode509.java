package lc_ea;

public class Leetcode509 {

	public int fib(int N) {

		if (N == 0)
			return 0;
		if (N == 1)
			return 1;

		int[] fib = new int[N + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= N; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[N];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode509 lc = new Leetcode509();
		int res = lc.fib(0);
		System.out.println("res= " + res);
	}

}
