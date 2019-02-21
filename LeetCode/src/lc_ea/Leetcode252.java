package lc_ea;

import java.util.Arrays;
import java.util.Comparator;

//Input: [[0,30],[5,10],[15,20]]
//Output: false

public class Leetcode252 {

	public static boolean canAttendMeetings(Interval[] intervals) {

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start) {
					return 0;
				} else {
					return i1.start > i2.start ? 1 : -1;
				}
			}
		});

		for (int i = 1; i < intervals.length; i++) {
//			System.out.println(intervals[i].start);
			if (intervals[i].start < intervals[i - 1].end)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval intervals[] = new Interval[3];
		Interval i0 = new Interval(0, 30);
		Interval i1 = new Interval(5, 10);
		Interval i2 = new Interval(15, 20);
		intervals[0] = i0;
		intervals[1] = i1;
		intervals[2] = i2;

//		Interval intervals[] = new Interval[2];
//		Interval i0 = new Interval(7, 10);
//		Interval i1 = new Interval(2, 4);
//		intervals[0] = i0;
//		intervals[1] = i1;

		boolean res = canAttendMeetings(intervals);
		System.out.println("res= " + res);
	}
}
