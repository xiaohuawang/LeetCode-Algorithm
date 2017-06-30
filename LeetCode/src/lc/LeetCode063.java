package lc;

public class LeetCode063 {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;

		System.out.println("row= " + row);
		System.out.println("column = " + column);
		
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
		
		int sum[][] = new int[row][column];
		if (obstacleGrid[0][0] == 1) {
			sum[0][0] = 0;
		} else {
			sum[0][0] = 1;
		}

		for (int i = 1; i < row; i++) {

			if (sum[i - 1][0] == 0) {
				sum[i][0] = 0;
			} else if (obstacleGrid[i][0] == 0) {
				sum[i][0] = 1;
			} else if (obstacleGrid[i][0] == 1) {
				sum[i][0] = 0;
			}

		}

		for (int j = 1; j < column; j++) {
			if (sum[0][j - 1] == 0) {
				sum[0][j] = 0;
			} else if (obstacleGrid[0][j] == 0) {
				sum[0][j] = 1;
			} else if (obstacleGrid[0][j] == 1) {
				sum[0][j] = 0;
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if(obstacleGrid[i][j]==1){
					sum[i][j]=0;
				}else{
					sum[i][j]=sum[i][j-1]+sum[i-1][j];
				}
				
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(sum[i][j] + " ");

			}
			System.out.println();
		}


		return sum[row - 1][column - 1];
	}

	public static void main(String[] args) {
		// int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }};
		int[][] grid = { { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		int res =  uniquePathsWithObstacles(grid);
		 System.out.println(res + "");
	}

}
