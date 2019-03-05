package lc_ea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Implement a basic calculator to evaluate a simple expression string.
//
//The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
//
//Example 1:
//
//Input: "3+2*2"
//Output: 7
//Example 2:
//
//Input: " 3/2 "
//Output: 1
//Example 3:
//
//Input: " 3+5 / 2 "
//Output: 5
//Note:
//
//You may assume that the given expression is always valid.
//Do not use the eval built-in library function.

public class Leetcode227 {

	public int calculate(String s) {

		int res = 0;
		int number = 0;
		if (s.length() == 0)
			return 0;

		if (!s.contains("+") && !s.contains("-") && !s.contains("(") && !s.contains(")")) {
			return Integer.valueOf(s);
		}

		// parse the string
		s = "(" + s + ")";
		s = s.replaceAll("\\s+", "");
		System.out.println("s= " + s);

		List<String> list = new ArrayList();
		Stack<String> stack = new Stack();

		for (int i = 0; i < s.length(); i++) {
			System.out.println("stack= " + stack);
			String temp = s.substring(i, i + 1);

			// if the current input is a digit
			if (Character.isDigit(temp.charAt(0))) {
				while (i < s.length() - 1 && Character.isDigit(s.charAt(i))) {
					temp = s.substring(i, i + 1);
					number = number * 10 + (temp.charAt(0) - '0');
					i++;
				}
				System.out.println("number= " + number);
				stack.add(String.valueOf(number));
				number = 0;
				i--;
				continue;
			}

			// if string != ) keep pushing
			if (!temp.equals(")")) {
				stack.push(temp);
				// if string == ) pop until the first (
			} else {
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					list.add(stack.pop());
					if (stack.peek().equals("(")) {
						stack.pop();
						break;
					}
				}
				Collections.reverse(list);
				System.out.println("list= " + list);
				int current_num = 0;
				// list calculation
				current_num = calculate_list(list, current_num);

				System.out.println("current_num= " + current_num);
				list = new ArrayList();
				stack.push(String.valueOf(current_num));
				res = current_num;
			}
		}
		return res;
	}

	private int calculate_list(List<String> list, int current_num) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < list.size(); j++) {
			sb.append(list.get(j));
		}
//		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode227 lc = new Leetcode227();
//		String s = "(1+(4/5+2)-3*2)+(6*8)";
		String s = "3+2*2";
		lc.calculate(s);
	}

}
