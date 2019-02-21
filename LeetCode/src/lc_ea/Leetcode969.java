package lc_ea;

import java.util.ArrayList;
import java.util.List;

public class Leetcode969 {

	// flipping the largest number to the end
	public List<Integer> pancakeSort(int[] A) {

		List<Integer> list = new ArrayList();
		for (int i = A.length - 1; i > 0; i--) {
			// find the max index of the array
			printArray(A);
			int mIndex = getMIndex(A, i);
			System.out.println("mindex= " + mIndex);
			System.out.println("i= " + i);
			// if mIndex!=i
			if (mIndex != i) {
				// first flip it to index 0
				flip(A, mIndex);
				list.add(mIndex + 1);
				printArray(A);
				// then flip it to the end
				flip(A, i);
				list.add(i + 1);
				printArray(A);
			}
			System.out.println();
		}
		System.out.println(list);
		return null;
	}

	private void flip(int[] A, int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < index / 2 + 1; i++, index--) {
			int temp = A[i];
			A[i] = A[index];
			A[index] = temp;
		}
	}

	private int getMIndex(int[] A, int n) {
		// TODO Auto-generated method stub
		int max = A[0];
		int maxIndex = 0;
		for (int i = 0; i <= n; i++) {
			if (A[i] > max) {
				max = A[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private void printArray(int A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode969 lc = new Leetcode969();
		int A[] = { 1, 2, 3 };
		lc.pancakeSort(A);
	}

}
