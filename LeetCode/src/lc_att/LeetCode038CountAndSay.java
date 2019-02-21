package lc_att;

import java.util.Scanner;

public class LeetCode038CountAndSay {

	public String countAndSay(int n) {

		String res = "1";
		if (n == 0) {
			return res;
		}
		for (int i = 1; i < n; i++) {
			res = Helper(res);
			System.out.println("res= "+res);
			System.out.println();
		}

		return res;
	}

	private String Helper(String res) {
		
//		System.out.println("come");
		StringBuffer sb=new StringBuffer(); 
		for(int i=0;i<res.length();i++){
			int p=i;
//			count by p-i
			while(p<res.length()&&res.charAt(p)==res.charAt(i)){
				p++;
			}
			System.out.println("p= "+p);
			int count=p-i;
			sb.append(count).append(res.charAt(i));
			i=p-1;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LeetCode038CountAndSay sol = new LeetCode038CountAndSay();
		
		System.out.println("pls input the nth number you want, thank you");
		Scanner sc=new Scanner(System.in);
		String res = sol.countAndSay(sc.nextInt());
		System.out.println("res= "+res);
	}

}
