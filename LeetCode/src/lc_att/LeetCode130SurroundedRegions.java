package lc_att;

import java.util.LinkedList;

public class LeetCode130SurroundedRegions {
	
	char[][] board = { { 'X', 'X','X','X' }, { 'X','O', 'O','X' },{'X','X','O','X'},{'X','O','X','X'}};
	int count=0;
	
	public static void main(String[] args) {
		LeetCode130SurroundedRegions lc = new LeetCode130SurroundedRegions();

//		char[][] board = { { 'X', 'X','X','X' }, { 'X','O', 'O','X' },{'X','X','O','X'},{'X','O','X','X'}};
		lc.solve(lc.board);
		for (int i = 0; i < lc.board.length; i++) {
			for (int j = 0; j < lc.board[0].length; j++) {
				System.out.print(lc.board[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

	  public void solve(char[][] board) {
	        if(board == null || board.length == 0) return;
	        // 把四周一圈的所有'O'标记�?'X'，这些都是�?符�?��?�件的，最�?�会�?�会'O'
	        for(int i=0; i< board.length; i++){
	            fill(board, i, 0);   //检查所有第0列
	            fill(board, i, board[0].length-1); //检查所有最�?�1列
	        }
	        for(int j=0; j<board[0].length; j++){
	            fill(board, 0, j);   //检查所有第0行
	            fill(board, board.length-1, j); //检查所有最�?�1列
	        }
	        for(int i=0; i<board.length; i++){
	            for(int j=0; j<board[0].length; j++){
	                if(board[i][j] == 'O') board[i][j] = 'X';   //�?在�?�一片的'O'必然是被'X'包围
	                else if(board[i][j] == 'X') board[i][j] = 'O';  //�?��?�?符�?��?�件的'O'
	            }
	        }
	    }
	    
	    //把�?�一片的'O'�?��?'X',使用一个queue�?��?�BFS
	    public void fill(char[][] board, int i, int j){
	        count++;
	        System.out.println("count= "+count);
	    	if(board[i][j] != 'O') return;
	    	System.out.println("                 come");
	        board[i][j] = 'X';   //将所有'O'�?��?'X'；
	        
	        LinkedList<Integer> queue = new LinkedList<Integer>();
	        int code = i * board[0].length + j;   //相当于将格�?一次编�?�，code就是�?��?。
	        System.out.println("                 code= "+code);
	        System.out.println("                 i= "+i);
	        System.out.println("                 j= "+j);
	        queue.offer(code);   //'X'放入一个queue
	        
	        while(!queue.isEmpty()){
	            code = queue.poll();
	            int row = code / board[0].length;
	            int col = code % board[0].length;
	            //然�?�检查上下左�?�，开始flood fill
	            if(row > 0 && board[row-1][col] == 'O'){
	                queue.offer((row-1)*board[0].length + col);
	                board[row-1][col] = 'X';
	            }
	            if(row < board.length-1 && board[row+1][col] == 'O'){
	                queue.offer((row+1)*board[0].length + col);
	                board[row+1][col] = 'X';
	            }
	            if(col > 0 && board[row][col-1] == 'O'){
	                queue.offer((row)*board[0].length + col-1);
	                board[row][col-1] = 'X';
	            }
	            if(col < board[0].length-1 && board[row][col+1] == 'O'){
	                queue.offer((row)*board[0].length + col+1);
	                board[row][col+1] = 'X';
	            }            
	        }
	    }


	// private void solve(char[][] board) {
	// // TODO Auto-generated method stub
	//
	// }
}
