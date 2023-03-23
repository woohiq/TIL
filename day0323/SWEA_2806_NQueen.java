package day0323_백트래킹;

import java.util.Scanner;

public class SWEA_2806_NQueen {
	static int N, ans;
	static boolean[] row, col, diaLR, diaRL;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int tc = 0; tc<testCase; tc++) {
			N = sc.nextInt();
			ans = 0;
			col = new boolean[N];
			/*
			 * disLR 인덱스 번호
			 * 3 | 4 | 5 | 6
			 * 2 | 3 | 4 | 5
			 * 1 | 2 | 3 | 4
			 * 0 | 1 | 2 | 3
			 * 
			 * diaRL 인덱스 번호
			 * 0 | 1 | 2 | 3
			 * 1 | 2 | 3 | 4
			 * 2 | 3 | 4 | 5
			 * 3 | 4 | 5 | 6
			 */
			diaLR = new boolean[2*N-1];
			diaRL = new boolean[2*N-1];
			
			queen(0);
			System.out.println(ans);
		}
	}

	private static void queen(int rowNum) {
		if (rowNum == N) {ans++; return;}
		
		for (int i = 0; i<N; i++) {
			int colNum = i;
			if (col[i] || diaLR[colNum + N - rowNum - 1] || diaRL[rowNum + colNum]) continue;
			col[i] = true;
			diaLR[colNum + N - rowNum - 1] = true;
			diaRL[rowNum + colNum] = true;
			queen(rowNum + 1);
			col[i] = false;
			diaLR[colNum + N - rowNum - 1] = false;
			diaRL[rowNum + colNum] = false;
		}
	}
}
