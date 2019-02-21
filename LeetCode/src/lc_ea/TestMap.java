package lc_ea;

import java.util.HashMap;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap();
		map.put(1, 2);
		map.put(1, 1);
		System.out.println(map.get(1));
	}

}
