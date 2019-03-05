package test;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "123456789";
		System.out.println(test.substring(0, 3));
		System.out.println(test.substring(3));
//		test = test.substring(3);
		test = test.substring(0, test.length() - 3);
		System.out.println("test= " + test);
	}

}
