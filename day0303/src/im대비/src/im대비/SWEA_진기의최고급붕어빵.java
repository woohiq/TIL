package im대비;

import java.util.Scanner;

public class SWEA_진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] waiting = new int[N];
			
			for (int i = 0; i<N; i++) {
				waiting[i] = sc.nextInt();
			}
			
			//sorting the arrays
			for (int j = N-1; j > 0; j--) {
				for (int i = 0; i<j; i++) {
					if (waiting[i] > waiting[i+1]) {
						int tmp = waiting[i+1];
						waiting[i+1] = waiting[i];
						waiting[i] = tmp;
					}
				}	
			}
			
			String str = " Possible";
			for (int i = 0; i<N; i++) {
				if ((i+1) > waiting[i] / M * K ) str = " Impossible";
			}
			
			System.out.println("#"+(tc+1)+str);
		}
		
		
	}
}
