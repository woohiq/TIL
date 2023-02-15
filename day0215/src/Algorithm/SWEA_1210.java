package Algorithm;

import java.util.Scanner;

public class SWEA_1210 {
	public static void main(String[] args) {
		// 스캐너와 StringBuffer 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스만큼 반복 : 10회
		for (int tc = 0; tc<10; tc++) {
			// 테스트 케이스를 나타내는 정수 버리기
			sc.nextInt();
			
			// 입력을 받을 배열 선언, 0과 1과 2만 입력받으면 되므로(2는 단 하나) boolean으로 선언
			// 가로 좌표에 padding을 주어 자연스럽게 경계 조건 체크가 될 수 있도록
			boolean[][] grid = new boolean[100][102];
			
			// 시작 인덱스와 현재 인덱스를 나타낼 변수 Idx
			int Idx = 0;
			
			// 입력 넣기
			for (int i = 0; i<100; i++) {
				for (int j = 1; j<=100; j++) {
					int in = sc.nextInt();
					if (in == 1) grid[i][j] = true;
					// 만약 입력이 2라면 시작점이르모 Idx를 해당 위치의 가로 인덱스값으로 설정
					// 세로 인덱스값이 필요 없는 이유는 무조건 마지막 행이기 때문
					else if (in == 2) Idx = j;
				}
			}
			
			// 사다리타기 시작
			// 만약 좌, 우로 갈 수 있다면
			// 현재 위치는 이미 방문했다고 하기 위해 현재 위치를 false로 설정 한 뒤
			// Idx값을 늘리거나 줄여서 좌,우로 움직임을 구현
			for (int i = 99; i>=0; i--) {
				while(grid[i][Idx+1] || grid[i][Idx-1]) {
					if (grid[i][Idx+1]) {
						grid[i][Idx++] = false;
					} else {
						grid[i][Idx--] = false;
					}
				}
			}
			
			// 결과 출력
			sb.append("#"+(tc+1)+" "+(Idx-1)+"\n");	
		}
		System.out.println(sb);
	}
}
