package test01;

import java.util.Scanner;

public class SWEA_비밀2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testpossible = sc.nextInt();
		for (int tc = 1; tc<=testpossible; tc++) {
			int N = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();
			
			int[] scores = new int[100];
			
			for (int i = 0; i<N; i++) {
				int score = sc.nextInt();
				scores[score-1]++;
			}
			int ans = Integer.MAX_VALUE;
			for (int left = 1; left<N-1; left++) {
				for (int right = left+1; right<N; right++) {
					int l = 0;
					int m = 0;
					int r = 0;
					for (int i = 0; i<left; i++) {
						l += scores[i];
					}
					if (l > max || l < min) continue;
					for (int j = left; j<right; j++) {
						m += scores[j];
					}
					if (m > max || m < min) continue;
					for (int k = right; k<N; k++) {
						r += scores[k];
					}
					if (r > max || r < min) continue;
					
					int tmpMax = (l>m) ? l : m;
					tmpMax = (r>tmpMax) ? r : tmpMax;
					int tmpMin = (l<m) ? l : m;
					tmpMin = (r<tmpMin) ? r : tmpMin;
					
					if ((tmpMax-tmpMin) < ans ) ans = tmpMax-tmpMin;
				}
			}
			if (ans == Integer.MAX_VALUE) ans = -1;
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
