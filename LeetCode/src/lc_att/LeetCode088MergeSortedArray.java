package lc_att;

public class LeetCode088MergeSortedArray {

	// m is the length of the first string, n is the length for the second
	// Leetcode 088 - Merge Sorted Array - 从�?��?�左扫.java

	// 维护三个index，分别对应数组A，数组B，和结果数组。
	// 然�?�A和B�?�时从�?�往�?扫，�?次迭代中A和B指�?�的元素大的便加入结果数组中，然�?�index-1，�?�一个�?动。
	// 从�?�往�?扫是因为这个题目中结果�?然放在A中，如果从�?扫会有覆盖掉未检查的元素的�?�能性。

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		System.out.println("m= " + m + " n=" + n);
		int index1 = m - 1, index2 = n - 1, index3 = m + n - 1;

		while (index1 >= 0 && index2 >= 0) {
			System.out.println("come");
			System.out.println("index2= "+index2+"  index1= "+index1);
			if (nums1[index1] < nums2[index2]) {
				nums1[index3] = nums2[index2];
				index3--;
				index2--;
			} else {
				nums1[index3] = nums1[index1];
				index3--;
				index1--;
			}
			System.out.println("index2= "+index2+"  index1= "+index1);
		}

		while (index2 >= 0) {
			nums1[index3]=nums2[index2];
			index3--;
			index2--;
		}
		
		System.out.println();
		System.out.println("answer");

		for (Integer i : nums1) {
			System.out.print(i + " ");
		}

	}

	public static void main(String[] args) {

		LeetCode088MergeSortedArray lc = new LeetCode088MergeSortedArray();

		//int[] A = { 2,0 };
		//int[] B = { 1 };
		
		   int[] A={0,0,0,0,0};
		   int[] B={1,2,3,4,5};
		// int[] A = { 1, 2, 3, 0, 0, 0 };
		// int[] B = { 4, 5, 6 };
		// int[] A = { 1, 3, 5, 9, 0, 0, 0 };
		// int[] B = { 2, 4, 6 };

		System.out.println("len diff= " + (A.length - B.length));

		for (Integer i : A) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (Integer i : B) {
			System.out.print(i + " ");
		}
		System.out.println();

		lc.merge(A, A.length - B.length, B, B.length);

	}

}
