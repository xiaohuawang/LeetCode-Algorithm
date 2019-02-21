package lc_ea;

import java.util.LinkedList;
import java.util.Queue;

//In an array A containing only 0s and 1s, a K-bit flip consists of choosing a (contiguous) subarray of length K and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
//
//Return the minimum number of K-bit flips required so that there is no 0 in the array.  If it is not possible, return -1.
//
// 
//
//Example 1:
//
//Input: A = [0,1,0], K = 1
//Output: 2
//Explanation: Flip A[0], then flip A[2].
//Example 2:
//
//Input: A = [1,1,0], K = 2
//Output: -1
//Explanation: No matter how we flip subarrays of size 2, we can't make the array become [1,1,1].
//Example 3:
//
//Input: A = [0,0,0,1,0,1,1,0], K = 3
//Output: 3
//Explanation:
//Flip A[0],A[1],A[2]: A becomes [1,1,1,1,0,1,1,0]
//Flip A[4],A[5],A[6]: A becomes [1,1,1,1,1,0,0,0]
//Flip A[5],A[6],A[7]: A becomes [1,1,1,1,1,1,1,1]

public class Leetcode995 {

	public int minKBitFlips(int[] A, int K) {

		int total_flip = 0;
		int current_flip = 0;
		Queue<Integer> flip_index_queue = new LinkedList<Integer>();

		for (int i = 0; i < A.length; i++) {

			// if the first number in the flip_index_queue can't affect the current number

			// for example:
			// if K=3, and A[0]=0, A[0] will be flipped
			// and the first flipped index=0, so the flip_index_queue.peek()=0
			// then when the loop comes i=3 flip_index_queue=0
			// flip_index_queue.peek() + K == i
			// which means the flip operation from A[0], will not affect the current number
			// A[3]

			// Then we will poll the first index of the flipped queue (it's no longer
			// useful)
			// and decrease the current flip number
			if (!flip_index_queue.isEmpty() && flip_index_queue.peek() + K == i) {
				flip_index_queue.poll();
				current_flip--;
			}

			// if the current number need to be fliped

			// the value of the number = 0 and it has been flipped even numbers
			// of the current value = 1 and it has been flipped odd number
			if (A[i] == 0 && current_flip % 2 == 0 || A[i] == 1 && current_flip % 2 == 1) {
				// if we are not able perform flip operation
				if (i + K > A.length)
					return -1;

				// if we can do the flip operation
				// put the number into the flip queue
				flip_index_queue.add(i);
				// add the current_filp number by one
				current_flip++;
				// add the total_flip number by one
				total_flip++;
			}
		}
		// return the tota_flip number of making the whole array into 1
		return total_flip;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode995 lc = new Leetcode995();
		int A[] = { 0, 0, 0, 1, 0, 1, 1, 0 };
		int K = 3;
		int total_flip = lc.minKBitFlips(A, K);
		System.out.println("total flip=" + total_flip);
	}

}
