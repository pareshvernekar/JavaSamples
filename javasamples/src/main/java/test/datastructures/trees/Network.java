package test.datastructures.trees;
import java.util.*;
public class Network {
	
	static int TOLERANCE = 0;

	Resource root = null;

	public void boost() {
		inorderBoost(root.left);
		inorderBoost(root.right);
	}

	private void inorderBoost(Resource node) {
		if (node == null)
			return;
		int lossFromParent = node.loss;
		int lossToLeaf = lossToLeaf(node);
		int totalLoss = lossFromParent+lossToLeaf;
		if (totalLoss > TOLERANCE)
			node.setBooster(Boolean.TRUE);
		inorderBoost(node.left);
		inorderBoost(node.right);

	}

	private int lossToLeaf(Resource node) {
		if (node.left == null && node.right == null)
			return 0;
		if (node.left == null)
			return node.right.loss;
		else if (node.right == null)
			return node.left.loss;
		else
			return Math.max(node.left.loss,node.right.loss);

	}

	public void inOrderTraverse(Resource root) {
		if (root == null)
			return;
		System.out.println("Node :"+root.getName()+":isBooster:"+root.isBooster());
		inOrderTraverse(root.left);
		inOrderTraverse(root.right);
	}

	public Network() {
		root = new Resource("p",0);
		Resource temp = new Resource("q",1);
		temp.left = new Resource("s",2);
		temp.right = new Resource("t",2);
		root.left = temp;
		temp = temp.left;	//s
		temp.left= new Resource("w",3);
		temp.right = new Resource("x",1);
		temp = new Resource("r",3);
		root.right = temp;
		temp.left=new Resource("u",1);
		temp.right = new Resource("v",2);
		temp = temp.left;
		temp.left = new Resource("y",2);
		temp = root.right.right;	//v
		temp.left = new Resource("z",2);
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		TOLERANCE = scanner.nextInt();
		Network nw = new Network();
		nw.inOrderTraverse(nw.root);
		nw.boost();
		System.out.println("**************************************");
		nw.inOrderTraverse(nw.root);
		scanner.close();

	}

}

class Resource {
	Resource left = null;
	Resource right = null;
	boolean isBooster = Boolean.FALSE;
	String name = null;
	int loss = 0;

	Resource(String name, int loss) {
		this.name = name;
		this.loss = loss;
	}

	public Resource getLeft() {
		return this.left;
	}
	public void setLeft(Resource resLeft) {
		this.left = resLeft;
	}

	public Resource getRight() {
		return this.right;
	}

	public void setRight(Resource resRight) {
		this.right = right;
	}

	public String getName() {
		return this.name;
	}

	public int getLoss() {
		return this.loss;
	}

	public void setBooster(Boolean isBooster) {
		this.isBooster = isBooster;
	}

	public Boolean isBooster() {
		return this.isBooster;
	}
}