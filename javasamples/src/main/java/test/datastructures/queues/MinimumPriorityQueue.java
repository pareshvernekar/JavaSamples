package test.datastructures.queues;

import java.util.*;

public class MinimumPriorityQueue<T extends Comparable<T>> {
	
	private QNode<T> head = null;
	private int size = 0;

	public String toString() {
		StringBuilder strBuilder = null;
		if (head == null)
			return "NULL";
		else {
			strBuilder = new StringBuilder();
			QNode temp = head;
			while (temp != null) {
				if (strBuilder.length() == 0) {
					strBuilder.append("[").
					append(temp.getData()!=null?temp.getData().toString():"NULL");

				} else {
					strBuilder.append(",").
					append(temp.getData()!=null?temp.getData().toString():"NULL");
				}
				temp=temp.getNext();
			}	
			strBuilder.append("]");
		}
		return strBuilder.toString();
	}

	public void add(T data) {
		if (data == null)
			throw new IllegalArgumentException("Null values not allowed");

		if (head == null) 
			head = new QNode(data);
		else 
			insert(data);
		this.size+=1;
	}

	public T removeMin() {
		if (isEmpty())
			throw new NoSuchElementException("Queue is empty");
		QNode<T> temp = this.head;
		this.head = temp.getNext();
		temp.setNext(null);
		this.size-=1;
		return temp.getData();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size==0;
	}
	private void insert(T data) {
		QNode temp = head;
		QNode prev = temp;
		QNode newNode = new QNode(data);
		if (head.getData().compareTo(data) >= 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			while (temp != null && temp.getData().compareTo(data) < 0) {
				prev = temp;
				temp = prev.getNext();
			} 
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
		}
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		MinimumPriorityQueue<Integer> queue1 = new MinimumPriorityQueue<Integer>();
		try {
			System.out.println("Q1 Min:"+queue1.removeMin());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Q1 isEMpty:"+queue1.isEmpty());
		System.out.println("Q1 size:"+queue1.size());
		queue1.add(9);
		queue1.add(4);
		queue1.add(2);
		queue1.add(10);
		queue1.add(8);
		queue1.add(5);
		System.out.println("Q1 size:"+queue1.size());
		System.out.println(" Q1:"+queue1.toString());
		System.out.println(queue1.removeMin());
		System.out.println(queue1.removeMin());
		System.out.println(" Q1:"+queue1.toString());
		scanner.close();
	}

}

class QNode<T extends Comparable<T>> {
	
	private QNode next;
	private T data;

	public QNode(T data) {
		this.data = data;
	}

	public void setNext(QNode next) {
		this.next = next;
	}

	public QNode getNext() {
		return this.next;
	}

	public T getData() {
		return this.data;
	}
}
