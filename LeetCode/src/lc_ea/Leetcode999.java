package lc_ea;

public class Leetcode999 {

	int count = 0;
	int row = 0;
	int col = 0;
	int dir_row[] = { 1, -1, 0, 0 };
	int dir_col[] = { 0, 0, 1, -1 };

	public int numRookCaptures(char[][] board) {

//		System.out.println(board[5][5]);
		row = board.length;
		col = board[0].length;

//		System.out.println("row= " + row);
//		System.out.println("col = " + col);
		int b_row = -1;
		int b_col = -1;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				char current_char = board[i][j];
				if (current_char == 'R') {
					b_row = i;
					b_col = j;
				}
			}
		}
//		System.out.println("b_row= " + b_row);
//		System.out.println("b_col= " + b_col);

		for (int direction = 0; direction <= 3; direction++) {
			System.out.println("dir= " + direction);
			checkP(b_row, b_col, direction, board);
		}
		return count;
	}

	private void checkP(int b_row, int b_col, int direction, char board[][]) {
		// TODO Auto-generated method stub
		// check upper direction
		while (b_row > 0 && b_row < row - 1 && b_col > 0 && b_col < col - 1) {

			b_row += dir_row[direction];
			b_col += dir_col[direction];

			char current_char = board[b_row][b_col];
//			System.out.println("b_row= " + b_row);
//			System.out.println("b_col= " + b_col);
//			System.out.println("current_char" + current_char);

			if (current_char != '.') {
				if (current_char == 'P' || current_char == 'p') {
					System.out.println("count++");
					count++;
				}
				return;
			}
//			System.out.println();

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode999 lc = new Leetcode999();
		char[][] board = { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
				{ '.', '.', '.', 'p', '.', '.', '.', '.' }, { 'p', 'p', '.', 'R', '.', 'p', 'B', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'B', '.', '.', '.', '.' },
				{ '.', '.', '.', 'p', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } };
		int res = lc.numRookCaptures(board);
		System.out.println("res=" + res);
	}

}

//char[][] board = { 
//         { '.', '.', '.', '.', '.', '.', '.', '.' },
//		   { '.', '.', '.', 'p', '.', '.', '.', '.' },
//		   { '.', '.', '.', 'p', '.', '.', '.', '.' }, 
//		   { 'p', 'p', '.', 'R', '.', 'p', 'B', '.' },
//		   { '.', '.', '.', '.', '.', '.', '.', '.' }, 
//		   { '.', '.', '.', 'B', '.', '.', '.', '.' },
//		   { '.', '.', '.', 'p', '.', '.', '.', '.' }, 
//		   { '.', '.', '.', '.', '.', '.', '.', '.' } };
