package test.datastructures.trees;

import java.util.*;

public class SwapSubTrees {


	TreeNode<Integer> makeTree(Integer[] data) {

        TreeNode<Integer> root = null;

        for (Integer t:data) {

            if (root == null) {
                    root = new TreeNode(t);
            } else {
                    addNode(root, t);
            }
        }
        return root;
    }
    private  void addNode(TreeNode<Integer> root, Integer data) {
                                if (root.data.compareTo(data) >=0) {
                                        if (root.left == null) {
                                                root.left = new TreeNode(data);
                                        } else {
                                                addNode(root.left,data);
                                        }
                                } else {

                                        if (root.right == null) {
                                                root.right = new TreeNode(data);
                                        } else {
                                                addNode(root.right,data);
                                        }
                                }
                }
    TreeNode<Integer> swapSubTrees(TreeNode<Integer> root) {

    	if (root == null)
    		return null;
    	TreeNode<Integer> leftNode = root.left;
    	TreeNode<Integer> rightNode = root.right;

    	root.left=rightNode;
    	root.right = leftNode;
    	swapSubTrees(root.left);
    	swapSubTrees(root.right);
    	return root;
    }

    void inOrder(TreeNode<Integer> treeNode) {
		
		if (treeNode == null)
			return;
		inOrder(treeNode.left);
		System.out.println(treeNode.data);
		inOrder(treeNode.right);
	}
	public static void main(String[] argv) {
		SwapSubTrees st = new SwapSubTrees();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
        Integer[] data = new Integer[N];
        for (int i=0;i<N;i++) {
               data[i]=new Integer(scanner.nextInt());
        }
        TreeNode<Integer> root = st.makeTree(data);
        System.out.println("BEFORE SWAP");
        st.inOrder(root);
        root = st.swapSubTrees(root);
        System.out.println("AFTER SWAP");
        st.inOrder(root);
		scanner.close();
	}
}