package lc_ea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Leetcode224 {

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
		// System.out.println("s= " + s);

		List<String> list = new ArrayList();
		Stack<String> stack = new Stack();
		// Stack<Integer> integer_stack = new Stack<Integer>();

		for (int i = 0; i < s.length(); i++) {
			System.out.println("stack= " + stack);
			String temp = s.substring(i, i + 1);

			// if the current input is a digit
			if (Character.isDigit(temp.charAt(0))) {
				while (i < s.length() - 1 && Character.isDigit(s.charAt(i))) {
					System.out.println("come");
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
				// System.out.println(list);
				int current_num = 0;
				for (int j = 0; j < list.size(); j++) {
					// System.out.println(list);
					if (j == 0)
						current_num += Integer.valueOf(list.get(j));
					else if (list.get(j).equals("+")) {
						// System.out.println("+");
						current_num += Integer.valueOf(list.get(j + 1));
					} else if (list.get(j).equals("-")) {
						// System.out.println("-");
						current_num -= Integer.valueOf(list.get(j + 1));
					}
					// System.out.println("current_num= " + current_num);
				}
				list = new ArrayList();
				stack.push(String.valueOf(current_num));
				res = current_num;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s = "(1+(4+5+2)-3)+(6+8)";
		String s = "1 + 1";
//		String s = "1 - 111";
//		String s = "2147483647";
		Leetcode224 lc = new Leetcode224();
		int res = lc.calculate(s);
		System.out.println("res= " + res);
	}

}
