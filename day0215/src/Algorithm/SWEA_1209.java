package Algorithm;

import java.util.Scanner;

public class SWEA_1209 {
	public static void main(String[] args) {
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트케이스 10개이므로 10번 반속
		for (int i = 0; i<10; i++) {
			// 맨 처음 정수 버리기
			sc.nextInt();
			// 정수 입력을 저장할 2차원 배열 선언
			int[][] grid = new int[100][100];
			
			// 정수 입력 받기
			for (int j = 0; j<100; j++) {
				for (int k = 0; k<100; k++) {
					grid[j][k] = sc.nextInt();
				}
			}
			
			// 최대값을 저장할 maximum 변수
			// 순간 행,렬,대각 합을 저장할 tmpSum
			int maximum = Integer.MIN_VALUE;
			int tmpSum = 0;
			
			// 행의 합 체크
			for (int j = 0; j<100; j++) {
				for (int k = 0; k<100; k++) {
					tmpSum += grid[j][k]; 
				}
				if (tmpSum > maximum) maximum = tmpSum;
				tmpSum = 0;
			}
			
			// 열의 합 체크
			for (int j = 0; j<100; j++) {
				for (int k = 0; k<100; k++) {
					tmpSum += grid[k][j]; 
				}
				if (tmpSum > maximum) maximum = tmpSum;
				tmpSum = 0;
			}
			
			// 대각 왼쪽위~오른아래 합 체크
			for (int j = 0; j<100; j++) {
				tmpSum += grid[j][j];
			}
			if (tmpSum > maximum) maximum = tmpSum;
			tmpSum = 0;
			
			// 대각 오른위~왼쪽아래 합 체크
			for (int j = 0; j<100; j++) {
				tmpSum += grid[j][99-j];
			}
			if (tmpSum > maximum) maximum = tmpSum;
			tmpSum = 0;
			
			// 결과 출력
			sb.append("#"+(i+1)+" "+maximum+"\n");
		}
		System.out.println(sb);
	}
}
