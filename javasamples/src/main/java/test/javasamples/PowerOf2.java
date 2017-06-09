package test.javasamples;

import java.util.Scanner;

public class PowerOf2 {
	
	static boolean isPowerOf2(int n) {
		
		n &= n-1;
		return n==0?Boolean.TRUE:Boolean.FALSE;
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(isPowerOf2(n));
		scanner.close();
	}
}
