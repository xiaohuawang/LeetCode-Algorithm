package lc_ea;

public class Leetcode983 {

//Input: days = [1,4,6,7,8,20], costs = [2,7,15]
//Output: 11
//Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
//Output: 17

	public int mincostTickets(int[] days, int[] costs) {

		int min_cost[] = new int[366];
		boolean isday[] = new boolean[366];
		for (int day : days) {
			isday[day] = true;
		}

//		for (int i = 0; i < 30; i++) {
//			System.out.println(isday[i]);
//		}

		for (int i = 1; i <= days[days.length - 1]; i++) {
			// if we dont neet ticket today
			if (isday[i] == false) {
				min_cost[i] = min_cost[i - 1];
				// if we need ticket today
			} else {
				min_cost[i] = min_cost[i - 1] + costs[0];
				min_cost[i] = Math.min(min_cost[i], min_cost[Math.max(0, i - 7)] + costs[1]);
				min_cost[i] = Math.min(min_cost[i], min_cost[Math.max(0, i - 30)] + costs[2]);
			}
		}
		return min_cost[days[days.length - 1]];
	}

	public static void main(String[] args) {
		int days[] = { 1, 4, 6, 7, 8, 20 };
		int costs[] = { 2, 7, 15 };
		Leetcode983 lc = new Leetcode983();
		int res = lc.mincostTickets(days, costs);
		System.out.println("res= " + res);
	}
}