package test.algorithms.sort;

import java.util.*;
public class InsertionSort<T extends Comparable<T>> {
	
	public void insertionSort(T[] elements) {
		if (elements == null)
			throw new IllegalArgumentException();
		int len = elements.length;
		int j = 0;
		T temp= null, min = null;
		for (int i=0;i<len-1;i++) {
			min = elements[i];
			j=i;
			for (int k=i+1;k<len;k++) {
				if (elements[k].compareTo(min) < 0) {
					min = elements[k];
					j = k;
				}
			}
			temp = elements[i];
			elements[i]=min;
			elements[j]=temp;

		}
	} 

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		Integer[] elements = new Integer[N];
		for (int i=0;i<N;i++) {
			elements[i]=scanner.nextInt();
		}
		InsertionSort<Integer> sort = new InsertionSort<Integer>();
		sort.insertionSort(elements);
		System.out.println("*********************");
		for (int i=0;i<N;i++) {
			System.out.println(elements[i]);
		}
		scanner.close();
	}
}