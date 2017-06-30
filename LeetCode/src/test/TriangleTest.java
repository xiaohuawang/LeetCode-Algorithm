package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleTest {

	public List<List<Integer>> generate(int rowIndex) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		int triangle[][] = new int[rowIndex + 1][rowIndex + 1];
		triangle[0][0] = 1;
		temp.add(triangle[0][0]);
		res.add(temp);

		if(rowIndex==2){
			temp=new ArrayList<Integer>();
			temp.add(1);
			temp.add(1);
			res.add(temp);
			return res;
		}
		for (int i = 2; i < rowIndex + 1; i++) {

			temp = new ArrayList<Integer>();
			triangle[i][0] = 1;
			triangle[i][i - 1] = 1;

			for (int j = 1; j < i - 1; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i-1][j];
			}

			for (int j = 0; j < i; j++) {
				temp.add(triangle[i][j]);
			}
			res.add(temp);
		}
		return res;
	}

	public static void main(String[] args) {

		System.out.println("please input the level of the triangle");
		TriangleTest tt = new TriangleTest();
		Scanner sc = new Scanner(System.in);
		int rowIndex = sc.nextInt();

		List<List<Integer>> res = tt.generate(rowIndex);
		System.out.println("res.size=" + res.size());
		System.out.println();

		for (int i = 0; i < res.size(); i++) {
			for (int k = 0; k < res.size() - i; k++) {
				System.out.print(" ");
			}
			System.out.println(res.get(i));
		}
	}

}
