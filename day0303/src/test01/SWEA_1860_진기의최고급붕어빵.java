package test01;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1860_진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int testCase = sc.nextInt();
		here: for (int tc = 1; tc<=testCase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] waiting = new int[N];
			
			for (int i = 0; i<N; i++) {
				waiting[i] = sc.nextInt();
			}
			
			Arrays.sort(waiting);
			
			for (int i = 0; i<N; i++) {
				int max = waiting[i] / M;
				if (i+1 > max * K) {
					sb.append("#"+tc+" Impossible\n");
					continue here;
				}
			}
			sb.append("#"+tc+" Possible\n");
		}
		System.out.print(sb);
	}
}
