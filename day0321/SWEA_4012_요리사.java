package day0321;

import java.util.Scanner;

public class SWEA_4012_요리사 {
	static int N, half;
	static int[][] synergy;
	static boolean[] isSelected;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc<=testCase; tc++) {
			
			// N개의 재료중 절반을 골라야 한다
			// 따라서 N/2개만큼 고르면 됨
			N = sc.nextInt();
			half = N / 2;
			
			// 시너지 저장
			synergy = new int[N][N];
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}
			// 재료 선택 정보 저장
			isSelected = new boolean[N];
			
			// 차이의 최소를 저장해서 출력
			min = Integer.MAX_VALUE;

			// 재귀 시작후 결과 출력
			devideHalf(0, 0);
			
			System.out.println("#"+tc+" "+min);
			
		}
	}
	private static void devideHalf(int index, int selectCnt) {
		
		// 만약 절반을 뽑았다면
		// 한 쪽의 시너지 합과 다른 쪽의 시너지 합의 차이를 구함
		if (selectCnt == half) {
			int sum = 0;
			for (int i = 0; i<N; i++) {
				if (!isSelected[i]) continue;
				for (int j = i+1; j<N; j++) {
					if(isSelected[j]) {
						sum += synergy[i][j];
						sum += synergy[j][i];
					}
				}
			}
			int othersum = 0;
			for (int i = 0; i<N; i++) {
				if (isSelected[i]) continue;
				for (int j = i+1; j<N; j++) {
					if(!isSelected[j]) {
						othersum += synergy[i][j];
						othersum += synergy[j][i];
					}
				}
			}
			// 그 차이가 최소라면 최소를 갱신
			if (Math.abs(othersum - sum) < min) min = Math.abs(othersum - sum);
			return;
		}
		
		// 마지막 인덱스까지 검사했는데도 절반을 뽑지 못했다면 X
		if (index == N) return;
		
		// 해당 인덱스 뽑지않음
		devideHalf(index+1, selectCnt);
		isSelected[index] = true;
		// 해당 인덱스 뽑음
		devideHalf(index+1, selectCnt+1);
		isSelected[index] = false;
		
	}
}
