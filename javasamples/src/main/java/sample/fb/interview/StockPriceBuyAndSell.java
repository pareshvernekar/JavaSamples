package sample.fb.interview;

import java.util.*;

public class StockPriceBuyAndSell {
	
	public double maxProfit(double[] price) {
		double min = 0.0, max=0.0	;
		min = price[0];
		for (int i=1;i<price.length;i++) {
			if (price[i] > min) {
				max = Math.max(max,price[i]-min);
			} else {
				min = Math.min(min, price[i]);
			}
		}
		return (max);
	}

	public static void main(String[] argv) {
		double[] price = new double[]{10.0, 15.0, 30.0, 15.0, 19.0, 29.0, 15.0, 22.0, 27.0};
		StockPriceBuyAndSell s = new StockPriceBuyAndSell();
		System.out.println(s.maxProfit(price));
	}
}