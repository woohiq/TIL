package Algorithm;

import java.util.Scanner;

public class SWEA_11315 {
	
	public static int size;
	
	public static void main(String[] args) {
		
		// 스캐너를 이용해 testCase 갯수를 입력받고 그만큼 반복
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		/*
		 * 기본 idea
		 * 배열은 boolean으로 만들기
		 * 돌이 있으면 true
		 * 돌이 없으면 false
		 * 
		 * 열, 행, 대각에 대해서 true가 연속으로 5개(또는 그 이상) 있으면 YES, break
		 * 모든 경우에 대해서 없으면 NO
		 */
		here : for (int tc = 0; tc<testCase; tc++) {
			size = sc.nextInt();
			sc.nextLine();
			boolean[][] grid = new boolean[size][size];
			
			// grid에 입력 받기
			for (int i = 0; i<size; i++) {
				String inputStr = sc.nextLine();
				for (int j = 0; j<size; j++) {
					if (inputStr.charAt(j) == 'o') grid[i][j] = true;
				}
			}
		
			// 5개 연속인지 체크 시작
			// 행
			for (int i = 0; i<size; i++) {
				int cnt = 0;
				for (int j = 0; j<size; j++) {
					// 만약 돌이 있다면 cnt를 늘리고
					// 돌이 없다면 cnt를 초기화시킴
					// 돌이 5개가 되는 순간 루프를 빠져나와 다음 테스트케이스 실행
					if (grid[i][j]) cnt++;
					else cnt = 0;
					if (cnt == 5) {
						sb.append("#"+(tc+1)+" YES\n");
						continue here;
					}
				}
			}
			// 열
			for (int i = 0; i<size; i++) {
				int cnt = 0;
				for (int j = 0; j<size; j++) {
					if (grid[j][i]) cnt++;
					else cnt = 0;
					if (cnt == 5) {
						sb.append("#"+(tc+1)+" YES\n");
						continue here;
					}
				}
			}
			// 대각 오른쪽아래로
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					// 경계조건 체크
					if(borderCheck(i+4, j+4)) {
						// 연속으로 5개가 있는지 확인, 있다면 루프를 빠져나와 다음 테스트케이스
						if(grid[i][j]&&grid[i+1][j+1]&&grid[i+2][j+2]&&grid[i+3][j+3]&&grid[i+4][j+4]){
							sb.append("#"+(tc+1)+" YES\n");
							continue here;
						}
						else continue;
					}
					else continue;
				}
			}
			// 대각 왼쪽아래로
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					if(borderCheck(i-4, j+4)) {
						if(grid[i][j]&&grid[i-1][j+1]&&grid[i-2][j+2]&&grid[i-3][j+3]&&grid[i-4][j+4]){
							sb.append("#"+(tc+1)+" YES\n");
							continue here;
						}
						else continue;
					}
					else continue;
				}
			}
			sb.append("#"+(tc+1)+" NO\n");
		}
		System.out.println(sb);
	}
	
	// 경계조건을 체크하는 메서드
	public static boolean borderCheck(int x, int y) {
		return (x>=0 && y>=0 && x<size && y<size);
	}
	
}
