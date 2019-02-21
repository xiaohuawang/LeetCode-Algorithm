package lc_ea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TimeMap {

	/** Initialize your data structure here. */
	List<Time> list;

	public TimeMap() {
		list = new ArrayList();
	}

	public void set(String key, String value, int timestamp) {
		HashMap<String, String> map = new HashMap();
		map.put(key, value);
		Time timecurrent = new Time(map, timestamp);
		list.add(timecurrent);
		Collections.sort(list);
//		System.out.println(list.get(0).getIndex());
//		System.out.println(list.get(1).getIndex());
	}

	public String get(String key, int timestamp) {
		for (int i = list.size() - 1; i >= 0; i--) {
			if (timestamp >= list.get(i).getIndex()) {
				HashMap<String, String> targetMap = list.get(i).getMap();
				if (targetMap.containsKey(key))
					return targetMap.get(key);
			}
		}
		return "";
	}
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */

class Time implements Comparable<Time> {
	HashMap<String, String> map;
	int index;

	Time(HashMap<String, String> map, int index) {
		this.map = map;
		this.index = index;
	}

	public HashMap<String, String> getMap() {
		return this.map;
	}

	public int getIndex() {
		return this.index;
	}

	@Override
	public int compareTo(Time t) {
		// TODO Auto-generated method stub
		if (this.getIndex() < t.getIndex())
			return 1;
		else if (this.getIndex() == t.getIndex())
			return 0;
		else
			return -1;
	}
}
