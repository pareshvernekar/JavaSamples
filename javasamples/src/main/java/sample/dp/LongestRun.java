package sample.dp;

import java.util.*;

public class LongestRun {
	
	public static List<Integer> findRun(int[] data) {

		List<Integer> maxList = new ArrayList<Integer>();
		int len = data.length;
		int currMin = 0;
		for (int i=0;i<len;i++) {
			List<Integer> tempList = new ArrayList<>();
			currMin=data[i];

			int j = i+1;

			while  (j < len && data[j] > currMin) {
				tempList.add(currMin);
				currMin = data[j];
				j++;
			}
			tempList.add(currMin);
			if (tempList.size() >= maxList.size()) 
				maxList = tempList;
			if (j==len-1)
				break;
	
		}
		return maxList;

	}

	public static void main(String[] argv) {

		int[] data = new int[]{2,4,3,5,1,7,6,9,8};
		List<Integer> maxList = findRun(data);
		for(Integer i:maxList) {
			System.out.print(i+"\t");
		}
	}
}