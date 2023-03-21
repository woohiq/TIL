package day0321;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	static int N, L, max;
	static int[][] items;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 재료의 수 N
			// 제한 칼로리 L
			N = sc.nextInt();
			L = sc.nextInt();
			
			max = 0;
			
			// 주어진 재료들의 정보 입력
			items = new int[N][2];
			
			for (int i = 0; i<N; i++) {
				items[i][0] = sc.nextInt();
				items[i][1] = sc.nextInt();
			}
			
			// 재귀 출발
			take(0, 0, 0);
			System.out.println("#"+tc+" "+max);
		}
	}
	public static void take(int idx, int kcalSum, int scoreSum) {
		
		// 모든 인덱스에 대해 검사완료
		// 최대값 검사
		if (idx == N) {
			if (max < scoreSum) {
				max = scoreSum;
			}
			return;
		}
		
		// 해당 재료를 넣을 수 있으면 넣는경우 고려
		if(kcalSum + items[idx][1] <= L) {
			take(idx+1, kcalSum + items[idx][1], scoreSum + items[idx][0]);
		}
		// 해당 재료를 택하지 않은 경우
		take(idx+1, kcalSum ,scoreSum);
	}
}
