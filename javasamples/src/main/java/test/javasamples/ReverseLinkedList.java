package test.javasamples;

import java.util.Scanner;

public class ReverseLinkedList {

	
	
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		scanner.close();
	}
}

class Node<T> {
	
	T data;
	Node<T> next;
	
	Node(T t) {
		this.data = t;
	}
	
	void setNext(Node n) {
		this.next = n;
	}
	
	Node getNext() {
		return this.next;
	}
	
	T getData() {
		return this.data;
	}
	
	void setData(T t) {
		this.data = t;
	}
}