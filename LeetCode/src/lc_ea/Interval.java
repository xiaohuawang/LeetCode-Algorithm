package lc_ea;

public class Interval implements Comparable {
//public class Interval {

	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Interval i = (Interval) o;
		if (i.end < this.end)
			return 1;
		else if (i.end > this.end)
			return -1;
		else
			return 0;
	}
}