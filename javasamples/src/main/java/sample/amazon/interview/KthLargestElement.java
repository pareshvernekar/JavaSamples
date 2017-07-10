package sample.amazon.interview;

import java.util.*;

// Find the kth largest element in an unsorted array. 
//Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.
//1,2,3,4,5,6
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.


public class KthLargestElement {
	
	public int kmax(int[] input, int k) {
		Arrays.sort(input);
		return input[input.length -k];
	}
	public int kmaxMod(int[] input, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i=0;i<input.length;i++) {
			q.offer(input[i]);
		}
		for (int i=0;i<k-1;i++) {
			System.out.println(q.poll());
		}
		return q.poll();
	}

	public int kmaxMod1(int[] input, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>(k);
		for (int i=0;i<k;i++) {
			q.offer(input[i]);
		}
		for (int i=k;i<input.length;i++) {
			if (input[i]>q.peek()) {
				q.offer(input[i]);
			}
			if (q.size() > k)
				q.poll();
		}
		return q.poll();
	}


	public static void main(String[] argv) {
		int[] input = new int[]{3,2,1,5,6,4};
		KthLargestElement ke = new KthLargestElement();
		System.out.println("Output 1:"+ke.kmax(input,2));
		System.out.println("Output 2:"+ke.kmaxMod(input,2));
		System.out.println("Output 3:"+ke.kmaxMod1(input,3));

	}
}