package lc_ea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentHashMap;

public class Leetcode904Test {

	public static int totalFruit(int[] tree) {

		if (tree.length < 2)
			return 1;
		int currentLen = 0;
		int maxLen = 0;
		ConcurrentHashMap<Integer, List<Integer>> map = new ConcurrentHashMap();
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
					for (Integer current_key : map.keySet()) {
						if (current_key != tree[i - 1]) {
							map.remove(current_key);
						} else {
							List<Integer> value = map.get(current_key);
							List<Integer> newList = new ArrayList<>(Arrays.asList(value.get(value.size() - 1)));
							map.put(current_key, newList);
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
			maxLen = Math.max(maxLen, currentLen);
			currentLen = 0;
//			System.out.println(map);
		}
//		System.out.println("max len= " + maxLen);
		return maxLen;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int tree[] = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
//		int tree[] = { 0, 1, 2, 2 };
//		int tree[] = { 1, 2, 1 };
		int tree[] = { 1, 2, 3, 2, 2 };
//		int tree[] = { 1, 2, 1, 3, 1, 2, 1 };
		int res = totalFruit(tree);
		System.out.println(res);
	}

}
