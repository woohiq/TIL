package Algorithm;

import java.util.Scanner;

public class SWEA_1216 {
	
	public static char[][] grid;
	public static int max;
	
	public static void main(String[] args) {
		
		// 스캐너와 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 : 10개, 그만큼 반복
		int testCase = 10;
		for (int tc = 0; tc<testCase; tc++) {
			sc.nextLine();
			
			// (최대 회문 길이-1) max
			max = 0;
			
			// 글자판의 크기는 100 * 100
			grid = new char[100][0];
			for (int i = 0; i<100; i++) {
				grid[i] = sc.nextLine().toCharArray();
			}
			
			/*
			 * 어떤 좌표 X, Y에 대해
			 * (X, Y)에 있는 원소와
			 * (X, Y+1)에 있는 원소 값이 같다면 
			 * 길이 2만큼의 회문은 확정, 더 긴 회문의 가능성 있음
			 * 
			 * (X, Y-1)에 있는 원소와
			 * (X, Y+1)에 있는 원소 값이 같다면 
			 * 길이 3만큼의 회문은 확정, 더 긴 회문의 가능성 있음
			 * 
			 * 따라서 재귀 호출한다
			 */
			for (int i = 1; i<99; i++) {
				for (int j = 1; j<99; j++) {
					if (grid[i][j-1] == grid[i][j+1]) {
						palindromeCheck('R', i, j-1, j+1);
					} if (grid[i][j] == grid[i][j+1]) {
						palindromeCheck('R', i, j, j+1);
					} if (grid[i-1][j] == grid[i+1][j]) {
						palindromeCheck('C', j, i-1, i+1);
					} if (grid[i][j] == grid[i+1][j]) {
						palindromeCheck('C', j, i, i+1);
					}
				}
			}
			// 결과 출력
			sb.append("#"+(tc+1)+" "+(max+1)+"\n");
		}
		System.out.println(sb);
	}
	
	// 좌표가 배열의 인덱스 안에 있는지 확인하는 메서드
	public static boolean borderCheck(int x, int y) {
		return (x>=0 && y>=0 && x<100 && y<100);
	}
	
	// 재귀 호출하는 함수
	// type : row인지 column인지
	// other : 내가 상관하지 않는 축의 인덱스( row인경우 column의 축 번호 , vice versa )
	// start, end : 회문이 시작하고 끝나는 인덱스
	public static void palindromeCheck(char type, int other, int start, int end) {
		if (max < (end-start)) max = (end-start);
		if (type == 'R') {
			if (!borderCheck(start-1, end+1) || grid[other][start-1]!=grid[other][end+1]) return;
			else palindromeCheck(type, other, start-1, end+1);
		} else {
			if (!borderCheck(start-1, end+1) || grid[start-1][other]!=grid[end+1][other]) return;
			else palindromeCheck(type, other, start-1, end+1);
		}
	}
}
