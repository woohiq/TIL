package Algorithm;

import java.util.Scanner;

public class SWEA_1215 {
	public static void main(String[] args) {
		
		// 스캐너와 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 : 10개, 그만큼 반복
		int testCase = 10;
		for (int tc = 0; tc<testCase; tc++) {
			
			// 찾아야 하는 문자열의 길이 : size
			int size = sc.nextInt();
			sc.nextLine();
			
			// 글자판의 크기는 8x8
			char[][] grid = new char[8][0];
			for (int i = 0; i<8; i++) {
				grid[i] = sc.nextLine().toCharArray();
			}
						
			// 회문의 개수를 셀 cnt변수
			int cnt = 0;
			
			// 행을 탐색
			// 만약 길이가 N인 회문을 찾으려고 한다면
			// A 열과 ( A+ (N-1) )열을 비교
			// A+1 열과 ( A+ (N-2) )열을 비교
			// A+2 열과 ( A+ (N-3) )열을 비교
			// ...
			// A+k 열과 ( A+ (N-k-1) )열을 비교
			for (int i = 0; i<8; i++) {
				here: for (int j = 0; j<=8-size; j++) {
					for (int k = 1; k<=size/2; k++) {
						if (grid[i][j+k-1] != grid[i][j+size-k]) {
							continue here;
						}
					} 
					cnt++;
				}
			}
			
			// 열을 탐색
			for (int i = 0; i<8; i++) {
				here: for (int j = 0; j<=8-size; j++) {
					for (int k = 1; k<=size/2; k++) {
						if (grid[j+k-1][i] != grid[j+size-k][i]) {
							continue here;
						}
					} cnt++;
				}
			}
			
			// 찾은 개수 출력
			sb.append("#"+(tc+1)+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}
