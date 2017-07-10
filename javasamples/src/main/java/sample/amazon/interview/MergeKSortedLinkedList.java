package sample.amazon.interview;
// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

import java.util.*;

public class MergeKSortedLinkedList {

	public ListNode mergeSortedList(ListNode[] rootArr) {

		int len = rootArr.length;
		
	}
	
	public static void main(String[] argv) {

		int[] data1 = new int[]{4,5,6,7};
		int[] data2 = new int[]{1,2,3};
		int[] data3 = new int[]{8,9};
		MergeKSortedLinkedList msll = new MergeKSortedLinkedList();
		ListNode root1 = msll.createList(data1);
		ListNode root2 = msll.createList(data2);
		ListNode root3 = msll.createList(data3);
		
	}

}