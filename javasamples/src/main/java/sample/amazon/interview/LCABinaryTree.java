package sample.amazon.interview;
import java.util.*;
public class LCABinaryTree {

	public TreeNode findLCA(TreeNode root,TreeNode p, TreeNode q) {

		if (root==null || p == root || q == root) return root;
		TreeNode left = findLCA(root.left, p,q);
		TreeNode right = findLCA(root.right,p,q);
		if (left != null && right != null) return root;
		left = (left==null)?right:left;
		return left;
	}
	
	public static void main(String[] argv) {

		TreeNode p,q;
		TreeNode root = new  TreeNode();
		root.data=3;
		root.left = new TreeNode();
		root.left.data=5;
		p=root.left;
		root.right = new TreeNode();
		root.right.data=1;
		TreeNode node = new TreeNode();
		node.data=6;
		root.left.left=node;
		node = new TreeNode();
		node.data=2;
		root.left.right=node;
		node=root.left.right;
		node.left=new TreeNode();
		node.left.data=7;
		node.right=new TreeNode();
		node.right.data=4;
		q=node.right;
		node=root.right;
		node.left = new TreeNode();
		node.left.data=0;
		
		node.right=new TreeNode();
		node.right.data=8;
 
		LCABinaryTree lcb = new LCABinaryTree();
		TreeNode temp = lcb.findLCA(root,p,q);
		System.out.println(temp!=null?temp.data:"NULL");


	}
}