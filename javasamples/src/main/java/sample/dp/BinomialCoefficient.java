package sample.dp;

import java.util.*;

public class BinomialCoefficient {

	public static int binCoeff(int n, int r) {

		int N = 200;
		int[][] arr = new int[N][N];

		for (int i=0;i<=n;i++) arr[i][0]	=1;
		for (int j=0;j<=n;j++) arr[j][j] = 1;

		for (int i=1;i<=n;i++) {

			for (int j=1;j<i;j++) {
				arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
			}
		}
		for (int i=0;i<=n;i++) {
			for (int j = 0;j<=n;j++) {
				System.out.print(arr[i][j]);System.out.print("\t");
			}
			System.out.println();
		}

		return arr[n][r];

	}

	public static void main(String[] argv) {

		System.out.println(binCoeff(3,2));
	}
}