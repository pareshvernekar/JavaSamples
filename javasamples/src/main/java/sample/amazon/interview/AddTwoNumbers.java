package sample.amazon.interview;

import java.util.*;

// You are given two non-empty linked lists representing two non-negative integers. 
//The digits are stored in reverse order and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8


public class AddTwoNumbers {
	
	public ListNode add(ListNode head1, ListNode head2) {
		if (head1==null || head2 == null)
			throw new IllegalArgumentException("Invalid parameter values");
		int sum = 0;
		int carry = 0;

		ListNode temp1 = head1;
		ListNode temp2 = head2;
		ListNode resultHead = new ListNode(0,null);
		ListNode temp3 = null;
		while (temp1 != null && temp2 != null) {

			sum = carry+ temp1.data + temp2.data;
			if (temp3 == null) {
				temp3 = new ListNode(sum%10,null);
				resultHead.next= temp3;
			} else {
				temp3.next = new ListNode(sum%10,null);
				temp3=temp3.next;
			}
			carry = sum/10;
			temp1=temp1.next;
			temp2=temp2.next;
		}
		if  (temp1==null) {
			if (temp2 != null) {
				sum = carry + temp2.data;
				temp3.next=new ListNode(sum%10,null);
				carry = sum/10;
				temp3=temp3.next;
			}
		} else {
			if (temp1 != null) {
				sum = carry + temp1.data;
				temp3.next=new ListNode(sum%10,null);
				carry = sum/10;
				temp3=temp3.next;
			}
		}
		if ( carry > 0) {
			temp3.next=new ListNode(carry,null);
		}
		return resultHead.next;
	}

	public static void main(String[] argv) {

		ListNode n = null;
		ListNode head1 = new ListNode(2,null);
		ListNode temp = new ListNode(4,null);
		head1.next = temp;
		n = temp;
		temp = new ListNode(3,null);
		n.next = temp;

		ListNode head2 = new ListNode(5,null);
		temp = new ListNode(6,null);
		head2.next=temp;
		n = temp;
		temp=new ListNode(4,null);
		n.next = temp;

		AddTwoNumbers at = new AddTwoNumbers();
		ListNode result = at.add(head1,head2);
		while (result != null) {
			System.out.println(result.data);
			result = result.next;
		}

	}

}
class ListNode {
	Integer data;
	ListNode next;

	public ListNode() {
		
	}
	public ListNode(Integer data, ListNode next) {
		this.data = data;
		this.next = next;
	}

}