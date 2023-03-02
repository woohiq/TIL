package Algorithm;

import java.util.Scanner;

public class SWEA_7102 {
	public static void main(String[] args) {
		
		// 스캐너와 스트링버퍼를 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스와 숫자 N, M을 입력받음
		int tc = sc.nextInt();
		for (int i = 1; i<=tc; i++) {
			sb.append("#"+i);
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			/*
			 * 편법
			 * 
			 * 가장 빈도수 높은 숫자는 N+1, M+1, 그리고 그 사이 숫자
			*/
//			int small = Math.min(N+1, M+1);
//			int big = Math.max(N+1, M+1);
//			for (int j = small ; j<=big; j++) {
//				sb.append(" "+j);
//			}
			
			/*
			 * 빈도 수 직접 세기
			 * 
			 * N+M (최대값) 까지의 숫자 등장 빈도수를 세야 하므로
			 * N+M 까지의 인덱스를 갖는 배열을 선언해서 빈도수 계산
			 */
			int[] plus = new int[N+M+1];
			
			// 이중배열을 돌면서 빈도수 계산
			for (int j = 1; j<=N; j++) {
				for (int k = 1; k<=M; k++) {
					plus[j+k]++;
				}
			}
			
			// 가장 빈도수가 높은 수 = mostCommon
			int mostCommon = 0;
			// 각 배열을 돌면서 가장 빈도수가높은 수를 갱신
			for (int j = 0; j<plus.length; j++) {
				if(plus[j] > mostCommon) mostCommon = plus[j];
			}
			// 가장 빈도수가 높은 수라면, 출력
			for (int j = 0; j<plus.length; j++) {
				if(plus[j] == mostCommon) sb.append(" "+j);
			}
			
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
