package com.ssafy.ws.step3;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args) throws Exception{
		// 첫 번째 정수 (TEST CASE 개수)를 입력받음
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		
		// 배열의 크기 SIZE를 입력받음
		for (int i = 0; i<test_case; i++) {
			int size = Integer.parseInt(sc.nextLine());
			
			// 주어진 배열의 크기로 grid 배열 생성
			// 이 때 배열의 외곽에 PADDING을 1씩 주어 계산이 쉽도록 함
			char[][] grid = new char[size+2][size+2];
			// 만들어진 배열의 INDEX 1~size까지 채움, 따라서 INDEX=0, INDEX=size+1은 비어있음
			for (int j = 1; j<=size; j++) {
				for (int k = 1; k<=size; k++) {
					grid[j][k] = sc.next().charAt(0);
				}
			}
			
			// 배열에서 빌딩의 최대 높이를 저장하기 위한 배열 check 선언
			int[][] check = new int[size+2][size+2];
			// grid 배열을 돌면서 다음을 체크함
			// 1. 만약 해당 칸이 'G'라면 -> 해당 칸은 빌딩이 아니므로 높이 0
			// 2. 인접한 8개의 칸중 하나가 'G'라면 -> 해당 칸은 G와 인접했으므로 높이 2
			// 3. 위의 경우에 해당되지 않으면 -> 상하좌우의 이어진 'B' 갯수를 세어서 높이 저장
			for (int j = 1; j<=size; j++) {
				for (int k = 1; k<=size; k++) {
					// 1번 경우, 해당 칸이 'G' 일 때 높이를 0으로 설정하고 해당 칸검사를 끝마침
					if (grid[j][k] == 'G') {check[j][k] = 0; continue;}
					// 2번 경우, 인접 칸이 'G'일 때  높이를 2로 설정하고 해당 칸 검사를 끝마침
					else if (grid[j-1][k-1] == 'G' || grid[j-1][k] == 'G' || grid[j-1][k+1] == 'G' || grid[j][k-1] == 'G' || grid[j][k] == 'G' || grid[j][k+1] == 'G' || grid[j+1][k-1] == 'G' || grid[j+1][k] == 'G' || grid[j+1][k+1] == 'G' ) {check[j][k] = 2; continue;}
					// 3번 경우, 이어진 'B'의 갯수를 셈
					else {
						// 가로 축 양의 방향으로 이어진 개수 
						for (int x = j; x<=size; x++) {
							if (grid[x][k] == 'B') check[j][k] += 1;
							else continue;
						}
						// 가로 축 음의 방향으로 이어진 개수
						for (int x = j-1; x>=1; x--) {
							if (grid[x][k] == 'B') check[j][k] += 1;
							else continue;
						}
						// 세로 축 양의 방향으로 이어진 개수
						for (int x = k+1; x<=size; x++) {
							if (grid[x][k] == 'B') check[j][k] += 1;
							else continue;
						}
						// 세로 축 음의 방향으로 이어진 개수
						for (int x = k-1; x>=1; x--) {
							if (grid[x][k] == 'B') check[j][k] += 1;
							else continue;
						}
					}
				}
			}
			// 빌딩 최대 높이 찾기
			int max = 0;
			for (int j = 1; j<=size; j++) {
				for (int k = 1; k<=size; k++) {
					if (check[j][k] > max) max = check[j][k];
				}
			}
			// 결과 출력
			System.out.printf("#%d %d\n",i+1,max);
			// 남은 line 비우기
			sc.nextLine();
		}
	}
	
}
