package Algorithm;

import java.util.Scanner;

public class SWEA_2001 {
	public static void main(String[] args) {
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수 입력받고 그만큼 반복
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// 전체 배열의 크기 size
			// 파리채의 크기 flapperSize
			int size = sc.nextInt();
			int flapperSize = sc.nextInt();
			
			// 배열을 선언해서 입력을 받음
			int[][] grid = new int[size][size];
			
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			// 최대값을 저장하기 위한 변수
			int maximum = Integer.MIN_VALUE;
			
			// 배열을 돌면서 지역합들을 계산 후 최대값과 비교
			for (int i = 0; i<size-flapperSize+1; i++) {
				for (int j = 0; j<size-flapperSize+1; j++) {
					// 지역합 변수 tmp
					int tmp = 0;
					for (int k = 0; k<flapperSize; k++) {
						for (int l = 0; l<flapperSize; l++) {
							// 지역합에 파리채 구역만큼의 값들을 전부 더해서 계산
							tmp += grid[i+k][j+l];
						}
					}
					// 최대 판별
					if (tmp > maximum) maximum = tmp;
				}
			}
			// 결과 출력
			System.out.println("#"+(tc+1)+" "+maximum);
		}
	}
}
