package lc_ea;

//Example 1:
//Input: [[2,1,1],[1,1,0],[0,1,1]]
//Output: 4
//Example 2:
//
//Input: [[2,1,1],[0,1,1],[1,0,1]]
//Output: -1
//Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
//Example 3:
//
//Input: [[0,2]]
//Output: 0
//Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode994 {
	public int orangesRotting(int[][] grid) {

		int x_dir[] = { 1, 0, -1, 0 };
		int y_dir[] = { 0, -1, 0, 1 };
		List<Integer> x_index = new ArrayList<Integer>();
		List<Integer> y_index = new ArrayList<Integer>();
		int good_orange_num = 0;
		int rotten_orange_num_init = 0;
		int day_count = 0;
		int row = grid.length;
		int column = grid[0].length;
		System.out.println("row= " + row);
		System.out.println("column= " + column);
		Queue<Node> rotten_orange_queue = new LinkedList<>();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
//				System.out.println(grid[i][j]);
				if (grid[i][j] == 1) {
					good_orange_num++;
				} else if (grid[i][j] == 2) {
					x_index.add(i);
					y_index.add(j);
					rotten_orange_num_init++;
				}
			}
		}

		int rotten_orange_num = rotten_orange_num_init;

		if (good_orange_num == 0)
			return 0;

		for (int i = 0; i < x_index.size(); i++) {
			rotten_orange_queue.add(new Node(x_index.get(i), y_index.get(i)));
		}

//		System.out.println("number of init rotting orange= " + x_index.size());
//		System.out.println("good orange num= " + good_orange_num);

		// only stop when there's no rotten orange
		while (!rotten_orange_queue.isEmpty() && rotten_orange_num != rotten_orange_num_init + good_orange_num) {
			int size = rotten_orange_queue.size();
			// for all the current rotten orange in the current loop
			for (int i = 0; i < size; i++) {
				// poll the orange out
				Node current_node = rotten_orange_queue.poll();
				// check all 4 direction to make sure its neighbor is not out of boundary
				for (int direction = 0; direction < 4; direction++) {
					// if the connect neighbor is within the matrix
					if (current_node.getX() + x_dir[direction] >= 0 && current_node.getX() + x_dir[direction] < row
							&& current_node.getY() + y_dir[direction] >= 0
							&& current_node.getY() + y_dir[direction] < column) {
						Node new_node = new Node(current_node.getX() + x_dir[direction],
								current_node.getY() + y_dir[direction]);
						System.out.println("x= " + new_node.getX());
						System.out.println("y= " + new_node.getY());
						// if this is a good orange
						if (grid[new_node.getX()][new_node.getY()] == 1) {
							rotten_orange_queue.add(new_node);
							rotten_orange_num++;
							// mark the orange as rotten
							grid[new_node.getX()][new_node.getY()] = 2;
						}
					}
				}
			}
			day_count++;
//			System.out.println("day= " + day_count);
//			System.out.println(rotten_orange_queue);
		}

		// if there's still some good orange remaining
		if (rotten_orange_num != rotten_orange_num_init + good_orange_num)
			return -1;
		// if all the orange become rotten orange
		else
			return day_count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode994 lc = new Leetcode994();
//		int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
//		int grid[][] = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
//		int grid[][] = { { 0, 2 } };
		int grid[][] = { { 2 }, { 1 } };

		int res = lc.orangesRotting(grid);
		System.out.println("res= " + res);
	}

}

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
