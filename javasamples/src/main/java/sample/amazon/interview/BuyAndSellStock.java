package sample.amazon.interview;

import java.util.*;

public class BuyAndSellStock {
	
	public int maxProfit(int[] input) {

		int max = 0, min = input[0];
		for (int i=1;i<input.length;i++) {
			if (input[i]>min) {
				max = Math.max(max,input[i]-min);
			} else {
				min = input[i];
			}
		}
		return max;


	}

	public int modMaxProfit(int[] input) {
		int min = Integer.MAX_VALUE, max = 0;
		int i=0, j = input.length-1;

		while (i < j) {

			min=Math.min(min,input[i++]);
			max=Math.max(max, input[j--]);

		}
		if (min < max)
			return max-min;
		else
			return 0;


	}

	public static void main(String[] argv) {
		int[] input1 = new int[]{7,1,5,3,6,4};
		int[] input2 = new int[]{7,6,4,3,1};
		BuyAndSellStock bss = new BuyAndSellStock();

		System.out.println("Profit :1::"+bss.maxProfit(input1));
		System.out.println("Profit :1::"+bss.modMaxProfit(input1));

		System.out.println("Profit :2::"+bss.maxProfit(input2));
		System.out.println("Profit :2::"+bss.modMaxProfit(input2));

	}
}