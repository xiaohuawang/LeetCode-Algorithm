package lc_ea;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode253 {

	// Input: [[0,30],[5,10],[15,20]]
	// Output: false

	public int minMeetingRooms(Interval[] intervals) {

		int room_count = 0;
		int min_roomnum = 0;
		int max_size = 0;

		PriorityQueue<Interval> pq = new PriorityQueue<Interval>();
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

		pq.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			if (!pq.isEmpty()) {
				if (intervals[i].start < pq.peek().end) {
					pq.add(intervals[i]);
				} else {
					pq.poll();
					i--;
				}
			} else {
				pq.add(intervals[i]);
			}

			if (pq.size() > max_size) {
				max_size = pq.size();
			}
		}

		System.out.println("max_size= " + max_size);
//		System.out.println(pq.poll().end);
//		System.out.println(pq.poll().end);

		return max_size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode253 lc = new Leetcode253();
		Interval intervals[] = new Interval[3];
		Interval i0 = new Interval(0, 30);
		Interval i1 = new Interval(5, 10);
		Interval i2 = new Interval(15, 20);
		intervals[0] = i0;
		intervals[1] = i1;
		intervals[2] = i2;

//		Interval i0 = new Interval(7, 10);
//		Interval i1 = new Interval(2, 4);
//		intervals[0] = i0;
//		intervals[1] = i1;

		lc.minMeetingRooms(intervals);
	}

}
