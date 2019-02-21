package lc_ea;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Input: points = [[3,3],[5,-1],[-2,4]], K = 2
//Output: [[3,3],[-2,4]]
//(The answer [[-2,4],[3,3]] would also be accepted.)

public class Leetcode973 {

	public int[][] kClosest(int[][] points, int K) {

		List<Point> pointList = new ArrayList<Point>();

		for (int i = 0; i < points.length; i++) {
			pointList.add(new Point(points[i][0], points[i][1]));
		}
		System.out.println(pointList.size());
		System.out.println();

		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		for (int i = 0; i < K; i++) {
			pq.add(pointList.get(i));
		}

		for (int i = K; i < points.length; i++) {
			if (pointList.get(i).getDistance() < pq.peek().getDistance()) {
				pq.poll();
				pq.add(pointList.get(i));
			}
		}

		int len = pq.size();
		int[][] result = new int[len][2];
		for (int i = 0; i < len; i++) {
			Point temp = pq.poll();
			System.out.println();
			result[i][0] = temp.getX();
			result[i][1] = temp.getY();
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode973 lc = new Leetcode973();
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 }, { 9, 9 } };
		int K = 2;
		int[][] result = lc.kClosest(points, K);
		System.out.println("result len= " + result.length);
		for (int i = 0; i < result.length; i++) {
			System.out.println("thats the result");
			System.out.println(result[i][0]);
		}
	}
}

class Point implements Comparable<Point> {
	int x;
	int y;
	int distance;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getDistance() {
		return (int) (Math.pow(x, 2) + Math.pow(y, 2));
	}

	@Override
	public int compareTo(Point p) {
		// TODO Auto-generated method stub

		if (this.getDistance() < p.getDistance())
			return 1;
		else if (this.getDistance() > p.getDistance())
			return -1;
		return 0;
	}

}
