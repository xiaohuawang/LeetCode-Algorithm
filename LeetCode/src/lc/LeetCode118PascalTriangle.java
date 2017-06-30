package lc;

import java.util.ArrayList;
import java.util.List;

//[1],
//[1,1],
//[1,2,1],
//[1,3,3,1],
//[1,4,6,4,1]
//give 3 return [1,3,3,1]
public class LeetCode118PascalTriangle {

	public List<Integer> generate(int rowIndex) {

		// List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		int triangle[][] = new int[rowIndex + 2][rowIndex + 2];
		triangle[0][0] = 1;
		temp.add(triangle[0][0]);
		
		if (rowIndex == 1) {
			temp = new ArrayList<Integer>();
			temp.add(1);
			temp.add(1);
			return temp;
		}

		for (int i = 2; i <= rowIndex+1; i++) {
			temp = new ArrayList<Integer>();
			triangle[i][0] = 1;
			triangle[i][i - 1] = 1;

			for (int j = 1; j < i - 1; j++) {
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			}

			for (int j = 0; j < i; j++) {
				temp.add(triangle[i][j]);
			}
		}

		// System.out.println("res.size="+res.size());
		//
		// for(int i=0;i<res.size();i++){
		// System.out.println(res.get(i));
		// }

		return temp;
	}

	public static void main(String[] args) {

		LeetCode118PascalTriangle lc = new LeetCode118PascalTriangle();
		int rowIndex = 2;
		List<Integer> res = lc.generate(rowIndex);

		System.out.println(res);
	}
}
