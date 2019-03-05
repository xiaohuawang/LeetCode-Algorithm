package lc_ea;

public class Leetcode1004 {

	String S = "";

	public boolean isValid(String S) {

		this.S = S;
		removeFromStart();
		removeFromEnd();

		System.out.println("S= " + this.S);
		while (this.S.contains("abc")) {
			// System.out.println("yes");
			this.S = this.S.replaceAll("abc", "");
		}

		if (this.S.equals(""))
			return true;
		else
			return false;
	}

	private void removeFromStart() {
		// System.out.println(S.substring(0, 3));
		while (S.length() >= 3 && S.substring(0, 3).equals("abc")) {
			System.out.println("come");
			S = S.substring(3);
		}
	}

	private void removeFromEnd() {
		while (S.length() >= 3 && S.substring(S.length() - 3).equals("abc")) {
			S = S.substring(0, S.length() - 3);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode1004 lc = new Leetcode1004();
		// String S = "abcabcababcc";
		String S = "cababc";
		boolean res = lc.isValid(S);
		System.out.println("res= " + res);
	}

}
