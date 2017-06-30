package lc;

import java.util.ArrayList;
import java.util.List;

//[
// 	  [2],
//   [3,4],
//  [6,5,7],
// [4,1,8,3]
//]

public class LeetCode120Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {

//		System.out.println(triangle.size());
		int minSum[][] = new int[triangle.size()][];

		for (int i = 0; i < triangle.size(); i++) {
			minSum[i] = new int[i+1];
		}
		
		minSum[0][0]=triangle.get(0).get(0);
		
//		System.out.println(minSum[0].length);
//		System.out.println(minSum[1].length);
//		System.out.println(minSum[3].length);
		
		for(int i=1;i<triangle.size();i++){
			List<Integer> line=triangle.get(i);
//			System.out.println("line[0]= "+line.get(i));
			for(int j=0;j<=i;j++){
				if(j==0){
					minSum[i][j]=minSum[i-1][j]+line.get(0);
				}
				else if(j==i){
//					minSum[i][j]=line.get(i);
					minSum[i][j]=minSum[i-1][j-1]+line.get(j);
				}
				else{
					minSum[i][j]=Math.min(minSum[i-1][j-1],minSum[i-1][j])+line.get(j);
				}
			}
		}
		
//		System.out.println();
//		
//		for(int i=0;i<triangle.size();i++){
//			for(int j=0;j<i+1;j++){
//				System.out.print(minSum[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("len= "+minSum[triangle.size()-1].length);
		int min=minSum[triangle.size()-1][0];
		
		for(int i=1;i<triangle.size();i++){
			if(minSum[triangle.size()-1][i]<min){
				min=minSum[triangle.size()-1][i];
			}
//			System.out.print(minSum[triangle.size()-1][i]+" ");
		}
		return min;
	}

	public static void main(String[] args) {

		LeetCode120Triangle lc = new LeetCode120Triangle();
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		list.add(2);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(7);
		triangle.add(list);
		list = new ArrayList<Integer>();
		list.add(4);
		list.add(1);
		list.add(8);
		list.add(3);
		triangle.add(list);

		for (List<Integer> temp : triangle) {
			System.out.println(temp);
		}
		System.out.println();

		int res = lc.minimumTotal(triangle);
		System.out.println();
		System.out.println("res= " + res);
	}

}
