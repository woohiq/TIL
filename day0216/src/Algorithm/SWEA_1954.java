package Algorithm;

import java.util.Scanner;

public class SWEA_1954 {
	
	public static int size;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 숫자가 달팽이 집 형태로 배치되어야 하므로 cnt를 증가하면서 뱇치할 때 어느 방향으로 갈 건지 판별
		 * 이동의 우선순위를 오른쪽 - 아래 - 왼쪽 - 위로 둠
		 * 갔던곳은 체크 
		 * ( 근데 어차피 배열에 숫자가 채워지면서 0인지 여부만 체크하면됨 )
		 */
		// 우선순위 : 오른쪽, 아래, 왼쪽, 위
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		// 테스트 케이스 개수 받아 그만큼 반복
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// 배열의 크기를 입력받고 해당 크기의 배열 만들기
			size = sc.nextInt();
			int[][] grid = new int[size][size];
			
			// 배열에 쓰여질 숫자값을 저장할 변수 cnt
			int cnt = 0;
			
			// 배열을 돌때의 좌표값으로 사용할 currentX, currentY
			// currentX : 현재 X좌표 ( 배열의 첫 번째 원소 )
			// currentY : 현재 Y좌표 ( 배열의 두 번째 원소 )
			int currentX = 0;
			int currentY = 0;
			
			// 첫 좌표(0,0) 에 대해 작성하고 시작
			grid[currentX][currentY] = ++cnt;
			
			here : while(true) {
				
				// 이동할 수 있는 곳이 있다면
				// 계속 한 방향으로 이동
				// 이동이 전부 끝나면 다시 이동 방향 판별
				for (int i = 0; i<4; i++) {
					if (borderCheck(currentX+dx[i], currentY+dy[i]) && grid[currentX+dx[i]][currentY+dy[i]] == 0) {
						while(borderCheck(currentX+dx[i], currentY+dy[i]) && grid[currentX+dx[i]][currentY+dy[i]] == 0) {
							grid[currentX+dx[i]][currentY+dy[i]] = ++cnt;
							currentX += dx[i];
							currentY += dy[i];
						}
						continue here;
					}
					// 아무 곳도 갈 수 없는 경우 루프를 빠져나옴
				} break;
			}
			
			// 결과 출력
			System.out.println("#"+(tc+1));
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					System.out.print(grid[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	// 배열의 값(경계값)을 넘어가는지 확인하는 메서드 
	public static boolean borderCheck(int x, int y) {
		return (x>=0 && y>=0 && x<size && y<size);
	}
}
