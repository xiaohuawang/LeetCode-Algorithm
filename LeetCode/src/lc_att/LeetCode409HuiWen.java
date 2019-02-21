package lc_att;

public class LeetCode409HuiWen {

	String yangyang="sile";
	
//	public String longestPalindrome(String s) {
//	    if(s==null || s.length()<=1)
//	        return s;
//	 
//	    int len = s.length();
//	    int maxLen = 1;
//	    boolean [][] dp = new boolean[len][len];
//	 
//	    String longest = null;
//	    for(int l=0; l<s.length(); l++){
//	        for(int i=0; i<len-l; i++){
//	            int j = i+l;
//	            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
//	                dp[i][j]=true;
//	 
//	                if(j-i+1>maxLen){
//	                   maxLen = j-i+1; 
//	                   longest = s.substring(i, j+1);
//	                }
//	            }
//	        }
//	    }
//	 
//	    return longest;
//	}
	
	public int longestPalindrome(String s) {
		// 将字符串s转�?��?字符数组chars[]
		char chars[] = s.toCharArray();
		// 分别申明数组�?存�?�个大�?写字�?（共26个）出现的次数
		int lower[] = new int[26];
		int upper[] = new int[26];
		// �?存字符数组中字符出现奇数次的次数
		int odds = 0;
		// 循环将chars数组对应大�?写字符出现次数�?存在对应次数数组中
		for (int i = 0; i < s.length(); i++) {
			// 如果chars数组中字符为大写字符
			if (chars[i] < 'a') {
				// 按照字符大�?顺�?对应�?存大写字符出现次数
				upper[chars[i] - 'A']++;
			}
			// 如果chars数组中字符为�?写字符
			else {
				// 按照字符大�?顺�?对应�?存�?写字符出现次数
				lower[chars[i] - 'a']++;
			}
		}
		
		System.out.print("lower=  ");
		for(int i:lower){
			System.out.print(i+" ");
		}
		System.out.println();
		
		
		System.out.print("upper=  ");
		for(int i:upper){
			System.out.print(i+" ");
		}
		System.out.println();
		
		// �??历�?存大�?写字符出现次数的数组
		for (int j = 0; j < 26; j++) {
			// 如果大写字符中存在出现次数为奇数次的字符，odds+1
			if (upper[j] % 2 != 0)
				odds++;
			// 如果�?写字符中存在出现次数为奇数次的字符，odds+1
			if (lower[j] % 2 != 0)
				odds++;
		}
		// 如果s中没有出现次数为奇数的字符，返回字符串长度�?��?�
		if (odds == 0)
			return s.length();
		// �?�则，返回字符串长度-出现次数为奇数的字符个数+1
		// �?��?留出现最大奇数次数的字符
		else
			return s.length() - odds + 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeetCode409HuiWen lc = new LeetCode409HuiWen();
		String s = "abccccdd";
		int res = lc.longestPalindrome(s);
		System.out.println("res= " + res);

	}

}
