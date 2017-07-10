package test.datastructures.queues;

import java.util.*;

public class DequeTest {
	

	public static void init(Deque<Integer> deque, int[] arr) {
		int len = arr.length;
		for (int i=0;i<len;i++) {
			deque.addFirst(arr[i]);
		}

	}
	public static void main(String[] argv) {

		int[] arr = new int[]{10,20,30,40,50,60,70,80};
		Deque<Integer> deque = new LinkedList<Integer>();
		init(deque,arr);
		while(!deque.isEmpty()) {
			System.out.println("Data:"+deque.poll());
		}
		init(deque,arr);
		System.out.println("FIRST:"+deque.peek()+"::LAST:"+deque.peekFirst());

	}
}