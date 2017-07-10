package sample.amazon.interview;

import java.util.*;

public class ReverseLinkedList {

	public  ListNode reverse(ListNode head) {

		ListNode dummyHead = new ListNode();
		dummyHead.next = head;
		ListNode second = head;
		ListNode first = head.next;
		while (first != null) {
			second.next=first.next;
			first.next=dummyHead.next;
			dummyHead.next=first;
			first=second.next;
		}
		return dummyHead.next;

	}

	public ListNode createList(int[] input) {
		ListNode head = null, temp = null;
		for (int i=0;i<input.length;i++) {
			if (head == null) {
				head = new ListNode();
				head.data=input[i];
				temp = head;
			} else {
				temp.next = new ListNode();
				temp.next.data=input[i];
				temp=temp.next;
			}
		}
		return head;
	}

	public void traverse(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data);System.out.print("\t");
			temp=temp.next;
		}
		System.out.println();
	}

	public static void main(String[] argv) {

		int[] data = new int[]{1,2,3,4,5,6,7};
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode root = rll.createList(data);
		rll.traverse(root);
		root=rll.reverse(root);
		rll.traverse(root);

	}
	
}