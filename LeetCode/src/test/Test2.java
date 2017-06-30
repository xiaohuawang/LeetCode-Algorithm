package test;

public class Test2 {

	public boolean isInt(String s) {
		if (s.charAt(0) - '0' >= 0 && s.charAt(0) - '0' <= 9)
			return true;
		if (s.charAt(0) == '-' && s.length() > 1) {
			if (s.charAt(1) - '0' >= 0 && s.charAt(1) - '0' <= 9)
				return true;
		}
		return false;
	}

	public int operate(String s, int a, int b) {
		int res = 0;
		switch (s) {
		case "+":
			res = a + b;
			break;
		case "-":
			res = a - b;
			break;
		case "*":
			res = a * b;
			break;
		case "/":
			res = a / b;
			break;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 test2=new Test2();
		String input="25";
		boolean res=test2.isInt(input);
		System.out.println(res);
	}

}
