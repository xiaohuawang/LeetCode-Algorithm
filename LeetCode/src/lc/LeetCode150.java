package lc;

import java.util.LinkedList;
import java.util.Stack;

public class LeetCode150 {

	public int evalRPN(String[] input) {

		if(input==null){
			return 0;
		}
//		Stack<String> stack=new Stack<String>();
		LinkedList<String> stack = new LinkedList<String>();
		stack.push(input[0]);
		int count = 1;
		for (int i = 0; i < input.length-1; i++) {
//			 while (!stack.isEmpty()) {

			if (isNum(input[count])) {
				stack.push(input[count]);
			} else {
				String temp2 = stack.pop();
				String temp1 = stack.pop();
				System.out.println("temp1= " + temp1);
				System.out.println("temp2= " + temp2);
				int temp3 = operator(temp1, temp2, input[count]);
				stack.push(String.valueOf(temp3));
				System.out.println("temp3= " + temp3);
			}
			System.out.println(stack);
			count++;
		}

		return Integer.valueOf(stack.peek());
	}

	public int operator(String s1, String s2, String oper) {
		int ans = 0;
		switch (oper) {
		case "+":
			ans = Integer.parseInt(s1) + Integer.parseInt(s2);
			break;
		case "-":
			ans = Integer.parseInt(s1) - Integer.parseInt(s2);
			break;
		case "*":
			ans = Integer.parseInt(s1) * Integer.parseInt(s2);
			break;
		case "/":
			ans = Integer.parseInt(s1) / Integer.parseInt(s2);
			break;
		}
		return ans;
	}

	public boolean isNum(String s) {

		if (s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <= 9) {
			return true;
		}
		if (s.charAt(0) == '-' && s.length() > 1) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		LeetCode150 lc = new LeetCode150();
//		String[] input = { "-60", "-50", "-" };
//		String[] input = { "4", "13", "5", "/", "+" };
		String[] input={"2", "1", "+", "3", "*"};
//		String[] input={};
		int finalres=lc.evalRPN(input);
		System.out.println(finalres);
		// System.out.println(res);
	}

}
