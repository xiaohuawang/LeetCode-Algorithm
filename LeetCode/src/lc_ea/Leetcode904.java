package lc_ea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Leetcode904 {

	public static int totalFruit(int[] tree) {

		int currentLen = 0;
		int maxLen = 0;
		HashMap<Integer, List<Integer>> map = new HashMap();
		map.put(tree[0], new ArrayList<>(Arrays.asList(1)));

		for (int i = 1; i < tree.length; i++) {
			// map contain key
			if (map.containsKey(tree[i])) {
				List<Integer> tempList = map.get(tree[i]);
				if (tree[i] != tree[i - 1]) {
					tempList.add(1);
					map.put(tree[i], tempList);
				} else {
					tempList.set(tempList.size() - 1, tempList.get(tempList.size() - 1) + 1);
				}
				// map doesn't contain key
			} else {
				// need to delete the old key first, then add the new key
				if (map.size() > 1) {
					Iterator it = map.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry pair = (Map.Entry) it.next();
						if ((int) pair.getKey() != tree[i - 1]) {
							it.remove(); // avoids a ConcurrentModificationException
						} else {
							List<Integer> value = (List<Integer>) pair.getValue();
							List<Integer> newList = new ArrayList<>(Arrays.asList(value.get(value.size() - 1)));
							map.put((int) pair.getKey(), newList);
						}
					}
					map.put(tree[i], new ArrayList<>(Arrays.asList(1)));
					// just add the new key
				} else {
					map.put(tree[i], new ArrayList<>(Arrays.asList(1)));
				}
			}
			for (List<Integer> val_list : map.values()) {
				currentLen += val_list.stream().mapToInt(a -> a).sum();
			}
			System.out.println("current len= " + currentLen);
			maxLen = Math.max(maxLen, currentLen);
			currentLen = 0;
			System.out.println(map);
		}
		System.out.println("max len= " + maxLen);
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tree[] = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
//		int tree[] = { 1, 2, 1, 3, 1, 2, 1 };
		totalFruit(tree);
	}

}
