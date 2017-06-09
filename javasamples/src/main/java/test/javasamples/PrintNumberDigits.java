package test.javasamples;

import java.util.Scanner;

/*
 * Given 4356: Print
 * 4
 * 3
 * 5
 * 6
 */

public class PrintNumberDigits {

	static void printDigits(int N) {
		if (N < 10)
			System.out.println(N);
		else {
			int temp = N%10;
			printDigits(N/10);
			System.out.println(temp);
		}
	}
	
	
	public static void main(String[] argv) {
		 Scanner scanner = new Scanner(System.in);
		 int N = scanner.nextInt();
		 printDigits(N);
		 scanner.close();
	}
}
