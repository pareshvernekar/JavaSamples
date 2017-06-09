package test.datastructures.trees;


import java.util.*;

public class BinaryTreeCompare {


                 TreeNode<Integer> createTree(Integer[] data) {

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

                int compare(TreeNode<Integer> source, TreeNode<Integer> dest) {
                        if (source == null || dest == null)
                                return -1;
                        if (source == dest)
                                return 0;
                        return compareInOrder(source,dest);
                }

                int compareInOrder(TreeNode<Integer> source, TreeNode<Integer> dest) {
                        if ((source == null && dest != null) ||
                                (source != null && dest==null))
                                return -1;
                        if (source == dest)
                                return 0;

                        int result = 0;
                        result = compareInOrder(source.left, dest.left);
                        System.out.println("Left comparision:Result:"+result);
                        if (result != 0)
                                return result;
                        Integer sourceData = source.data;
                        Integer destData = dest.data;
                        result = sourceData.compareTo(destData) ;
                        System.out.println("Source data:"+source.data+":Dest data:"+dest.data+":Result:"+result);
                        if (result != 0)
                                return result;
                        result = compareInOrder(source.right,dest.right);
                        System.out.println("Right comparision:Result:"+result);
                     
                        return result;


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

                public static void main(String[] argv) {
                        Scanner scanner = new Scanner(System.in);
                        BinaryTreeCompare treeCompare = new BinaryTreeCompare();
                        int N = scanner.nextInt();
                        Integer[] data = new Integer[N];
                        for (int i=0;i<N;i++) {
                               data[i]=new Integer(scanner.nextInt());
                        }
                        TreeNode source = treeCompare.createTree(data);
                        N = scanner.nextInt();
                        Integer[] data1 = new Integer[N];
                        for (int i=0;i<N;i++) {
                               data1[i]=new Integer(scanner.nextInt());
                        }
                        TreeNode dest = treeCompare.createTree(data1);
                        System.out.println(treeCompare.compare(source,dest));
                        scanner.close();
                }

}
