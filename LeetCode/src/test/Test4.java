package test;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2147483647";
		char c = '9';
		int number = 0;
		number = 10 * number + (int) (c - '0');
		System.out.println("number= " + number);
		c = '3';
		number = 10 * number + (int) (c - '0');
		System.out.println(number);
	}

}
