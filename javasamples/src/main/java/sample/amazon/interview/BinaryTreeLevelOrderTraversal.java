package sample.amazon.interview;

import java.util.*;


// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

public class BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrderTraverse(TreeNode root) {
		Deque<TreeNode> parentQ = new LinkedList<>();
		Deque<TreeNode> childQ = new LinkedList<>();

		parentQ.offer(root);

		List<List<Integer>> results = new ArrayList<>();

		List<Integer> result = new ArrayList<>();
		while (!parentQ.isEmpty()) {

			TreeNode temp = parentQ.poll();
		
			if (temp != null) {
				if (temp.left != null)
					childQ.offer(temp.left);
				if (temp.right != null)
					childQ.offer(temp.right);
				result.add(temp.data);
			} 
			if (parentQ.isEmpty()) {
	
				parentQ = childQ;
				childQ = new LinkedList<>();
				results.add(result);
				result=new ArrayList<>();
			}

		}
		return results;
	}


	public static void main(String[] argv) {

		TreeNode root = new TreeNode();
		root.data = 3;

		TreeNode node = new TreeNode();
		node.data=9;
		root.left=node;
		
		node = new TreeNode();
		node.data=20;
		root.right=node;

		node = new TreeNode();
		node.data=15;
		root.right.left=node;

		node = new TreeNode();
		node.data=7;
		root.right.right=node;

		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		List<List<Integer>> results = b.levelOrderTraverse(root);
		for (List<Integer> result:results) {

			for (Integer i:result) {
				System.out.print(i);System.out.print("\t");
			}
			System.out.println();
		}	

	}
}