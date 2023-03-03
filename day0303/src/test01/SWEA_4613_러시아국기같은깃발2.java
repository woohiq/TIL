package test01;

import java.util.Scanner;

public class SWEA_4613_러시아국기같은깃발2 {
	
	public static char[][] map;
	public static int N, M, min;
	static char[] colors; // 재귀적으로 선택된 행 별 색깔을 담을 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			map = new char[N][M];
			colors = new char[N];
			
			for (int r = 0; r<N; r++) {
				String str = sc.next(); 
				char[] arr = str.toCharArray();
				for (int c = 0; c<M; c++) {
					map[r][c] = arr[c];
				}
			}
			
			min = Integer.MAX_VALUE;
			
			// 재귀적으로 색깔을 선택하는 함수 selectColor
			// 이전 색에 영향을 받으므로 이전 줄의 색깔에 대한 정보도 인자로 줘야 함
			selectColor(1, 'W');
			for (int j = 0; j<M; j++) {
				if (map[0][j] != 'W') min++;
			}
			for (int j = 0; j<M; j++) {
				if (map[N-1][j] != 'R') min++;
			}
			System.out.println("#"+tc+" "+min);
			
		}
	}
	
	// (i-1)번째 색깔이 주어질 때 i번째 색깔을 고르는 메서드
	public static void selectColor(int idx, char color) {
		
		if (idx == N-1) {
			if (color == 'W') return;
			else {
				int colorCnt = 0;
				for (int i = 1; i<N-1; i++) {
					int cnt = 0; 
					for (int j = 0; j<M; j++) {
						if (map[i][j] != colors[i]) cnt++;
					}
					colorCnt += cnt;
				}
				min = (min > colorCnt) ? colorCnt : min;
				return;
			}
		}
		
		if (color == 'W') {
			colors[idx] = 'W';
			selectColor(idx+1, 'W');
			colors[idx] = 'B';
			selectColor(idx+1, 'B');
		} else if (color == 'B') {
			colors[idx] = 'B';
			selectColor(idx+1, 'B');
			colors[idx] = 'R';
			selectColor(idx+1, 'R');
		} else {
			colors[idx] = 'R';
			selectColor(idx+1,'R');
		}
	}
}
