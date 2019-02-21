package lc_ea;

public class Leetcode161 {

	public boolean isOneEditDistance(String s, String t) {

		int count_diff = 0;

		if (s.equals(t))
			return false;
		// t is one char longer
		if (s.length() == t.length() - 1) {
			for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
				if (s.charAt(i) != t.charAt(j)) {
					i--;
					count_diff++;
				}
				if (count_diff == 2)
					return false;
			}
			// t is one char shorter
			// working on that
		} else if (s.length() == t.length() + 1) {
			for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
				if (s.charAt(i) != t.charAt(j)) {
					j--;
					count_diff++;
				}
				if (count_diff == 2)
					return false;
			}
			// t.len == s.len
		} else if (s.length() == t.length()) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i))
					count_diff++;
				if (count_diff == 2)
					return false;
			}
		} else
			return false;

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode161 lc = new Leetcode161();
		String s = "c";
		String t = "c";
		boolean res = lc.isOneEditDistance(s, t);
		System.out.println("res= " + res);
	}

}
