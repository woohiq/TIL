package Algorithm;

import java.util.Scanner;

public class SWEA_1208 {
	public static void main(String[] args) {
		
		// 입출력 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트케이스 : 10개
		int test_case = 10;
		for (int tc = 0; tc<test_case; tc++) {
			
			// dump갯수 입력 받아서 그만큼 반복
			int dumpNum = sc.nextInt();
			// 가로 개수 : 100개
			int[] ground = new int[100];
			for (int i = 0; i<100; i++) {
				ground[i] = sc.nextInt();
			}
			
			/*
			 * dump 시작
			 * base idea
			 * 1. 최대 최소를 찾는다
			 * 2. 최대값에서 1을 뺀 후 최소값에 1을 더함 
			 * 3. dump횟수만큼 반복
			 */
			for (int j = 0; j<dumpNum; j++) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxIdx = 0;
				int minIdx = 0;
				for (int k = 0; k<100; k++) {
					if (ground[k] > max) {
						max = ground[k];
						maxIdx = k;
					}
					if (ground[k] < min) {
						min = ground[k];
						minIdx = k;
					}
				}
				ground[maxIdx]--;
				ground[minIdx]++;
			}
			
			// dump 완료 후 최대 최소 높이 차이 반환
			// 일단 최대, 최소값 찾고 결과출력
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int maxIdx = 0;
			int minIdx = 0;
			for (int k = 0; k<100; k++) {
				if (ground[k] > max) {
					max = ground[k];
					maxIdx = k;
				}
				if (ground[k] < min) {
					min = ground[k];
					minIdx = k;
				}
			}
			
			// 결과출력
			sb.append("#"+(tc+1)+" "+(max-min)+"\n");
		}
		System.out.println(sb);
	}
}
