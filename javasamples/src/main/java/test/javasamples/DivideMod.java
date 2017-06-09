package test.javasamples;

import java.util.Scanner;

public class DivideMod {

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int n = (int)(Math.log10(N)+1);
		System.out.println("Number of digits:"+n);
		int temp = N;
		int maxDigit = 0, minDigit = 0;
		while (temp !=0) {
			maxDigit = temp / (int)(Math.pow(10, n-1));
			System.out.println("maxDigit:"+maxDigit);
			minDigit = temp%10;
			System.out.println("minDigit:"+minDigit);
			temp = temp - (maxDigit * (int)(Math.pow(10, n-1)));
			System.out.println("temp:"+temp);
			temp = temp/10;
			System.out.println("temp:"+temp);
			 n = (int)(Math.log10(temp)+1);
		}
		
	//	System.out.println(N/((int)Math.pow(10, n-1)));
	//	System.out.println(N%10);
		scanner.close();
	}
}

