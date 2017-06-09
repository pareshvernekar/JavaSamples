package test.datastructures;

public class BinarySearchTree {

	Node root;
	
	public Node addNode(int n) {
		if (root == null) {
			root = new Node(n);
		} else {
			//write code to add node
		}
		return root;
	}
	
}

class Node {
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getI() {
		return i;
	}

	
	public Node(int i) {
		this.i = i;
	}
	
	int i;
	Node left;
	Node right;
	
}

