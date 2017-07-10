package sample.dp;

import java.util.*;

public class ModFib {
	
	public static int optFib(int N) {

		int calc = 0;
		int[] values = new int[N+1];
		values[0]=0;
		values[1]=1;
		calc = calculateFib(N, values);

		return calc;
	}

	public static int optFib1(int N) {

		int back2 = 0, back1=1;
		int sum = 0;	
		for (int i=2;i<N;i++) {
			sum = back1+back2;
			back2=back1;
			back1=sum;
		}
		return (back1+back2);
	}


	private static int calculateFib(int N, int[] values) {
		if (N!=0 && values[N] == 0) {

			values[N]= calculateFib(N-1,values)+ calculateFib(N-2,values);
		} 
		return values[N];
	}
 	public static void main(String[] argv) {
 		System.out.println(optFib(5));
 		System.out.println("OPT:"+(optFib1(5)));
	}
}