package lc;

import java.util.Scanner;

public class LeetCode069 {

	public int mySqrt(int x) {

		if (x == 1)
			return 1;

		int l = 1;

		int r = x / 2;

		while (l <= r) {
			int mid = (l + r) / 2;
			System.out.print("l =" + l);
			System.out.println(" r =" + r);
			if (mid * mid == x) {
				return mid;
			}
			if (x/mid>mid) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		// return (l > x / l) ? l - 1 : l;
		return (l > x / l) ? l - 1 : l;
	}
	
//	  400000000
	  public int sqrt(int x) {
	        if (x == 0) return 0;
	        if (x < 4) return 1;

	        int L = 1;
	        int R = x/2;        //注意R的起始位置

	    
	        while(L < R){
	        	System.out.print("L =" + L);
				System.out.println(" R =" + R);
	           int M = (R+L)/2;
	            if(x/M >= M) {  //注意判断条件，以及不能写成 M*M <= x，否则会溢出
	                L = M+1;
	            } else{            
	                R = M-1;
	            }
	        }
	        return (L > x/L) ? L-1 : L; //注意返回条件，以及不能写成 L*L > x，否则会溢出
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode069 lc = new LeetCode069();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		int res = lc.mySqrt(input);
//		 int res = lc.sqrt(input);
		System.out.println("res= " + res);
	}

}
