package lc_att;

import java.util.List;

public class LeetCode051 {

	// public List<List<String>> solveNQueens(int n) {
	//
	// return null;
	// }

	// 皇�?�的个数
	private int queensNum = 4;
	// column[i] = j 表示第 i 列的第 j 行放置一个皇�?�
	private int[] queens = new int[queensNum + 1];
	// rowExists[i] = true 表示第 i 行有皇�?�
	private boolean[] rowExists = new boolean[queensNum + 1];
	// a[i] = true 表示�?�高左低的第 i �?�斜线有皇�?�
	private boolean[] a = new boolean[queensNum * 2];
	// b[i] = true 表示左高�?�低的第 i �?�斜线有皇�?�
	private boolean[] b = new boolean[queensNum * 2];

	// �?始化�?��?
	private void init() {
		for (int i = 0; i < queensNum + 1; i++) {
			rowExists[i] = false;
		}
		for (int i = 0; i < queensNum * 2; i++) {
			a[i] = b[i] = false;
		}
	}

	// 判断该�?置是�?�已�?存在一个皇�?�,存在则返回 true
	private boolean isExists(int row, int col) {
		return (rowExists[row] || a[row + col - 1] || b[queensNum + col - row]);
	}

	// 主方法：测试放置皇�?�
	public void testing(int column) {
		// �??历�?一行 1-4
		for (int row = 1; row < queensNum + 1; row++) {
			// 如果第 row 行第 column 列�?�以放置皇�?�
			System.out.println("row= " + row + " col= " + column + " answer=" + isExists(row, column));
			if (!isExists(row, column)) {
				// 设置第 row 行第 column 列有皇�?�
				System.out.println("row= " + row + " col= " + column);
				queens[column] = row;

				// 设置以第 row 行第 column 列为交�?�点的斜线�?�?�放置皇�?�
				rowExists[row] = a[row + column - 1] = b[queensNum + column - row] = true;
				// 全部�?试过，打�?�
				if (column == queensNum) {
					for (int col = 1; col <= queensNum; col++) {
						System.out.print("(" + col + "," + queens[col] + ")  ");
					}
					System.out.println();
				} else {
					// 放置下一列的皇�?�
					testing(column + 1);
				}
				System.out.println("roll back   		  row =" + row + " col= " + column);
				// 撤销上一步所放置的皇�?�，�?�回溯
				rowExists[row] = a[row + column - 1] = b[queensNum + column - row] = false;
			}
		}
	}

	// 测试
	public static void main(String[] args) {
		LeetCode051 lc = new LeetCode051();
		lc.init();
		// 从第 1 列开始求解
		lc.testing(1);

		// System.out.println(lc.isExists(3,3));
		// lc.rowExists[3]=true;
		// // column[i] = j 表示第 i 列的第 j 行放置一个皇�?� 3hang0lie
		// System.out.println(lc.isExists(3,3));

	}

}
