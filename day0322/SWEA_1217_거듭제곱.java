package day0322;

import java.util.Scanner;

public class SWEA_1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc<=10; tc++) {
			sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#"+tc+" "+recursiveMultiply(N, M));
		}
	}

	private static int recursiveMultiply(int n, int m) {
		if (m == 0) return 1;
		else if (m % 2 == 0) return recursiveMultiply(n, m/2) * recursiveMultiply(n, m/2);
		else return recursiveMultiply(n, (m-1)/2) * recursiveMultiply(n, (m-1)/2) * n;
	}
}
