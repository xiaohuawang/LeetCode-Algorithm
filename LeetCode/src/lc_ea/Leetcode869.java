package lc_ea;

public class Leetcode869 {

	public boolean reorderedPowerOf2(int N) {

		boolean res = isPowerOfTwo(N);
		System.out.println(res);
		return false;
	}

	private boolean isPowerOfTwo(int number) {

		if (number == 1)
			return true;

		if (number % 2 != 0)
			return false;
		else {
			for (int i = 0; i <= number; i++) {
				if (Math.pow(2, i) == number)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode869 lc = new Leetcode869();
		int N = 1;
		lc.reorderedPowerOf2(N);
	}

}
