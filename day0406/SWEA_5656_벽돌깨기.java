package samsung01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
	static int N, W, H, blocks, ans;
	static int[][] map;
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc<=testCase; tc++) {
			
			// N : 블록을 부술 수 있는 횟수
			// W : 전체 맵의 너비 ( 열의 수 )
			// H : 전체 맵의 높이 ( 행의 수 )
			// blocks : 남아있는 블록의 수
			// ans : 남아있는 블록이 가장 작을때의 수
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			blocks = 0;
			ans = Integer.MAX_VALUE;
			
			map = new int[H][W];
			
			for (int i = 0; i<H; i++) {
				for (int j = 0; j<W; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] > 0) blocks++;
				}
			}
			
			// 모든 순열 탐색 시작
			for (int i = 0; i<W; i++) {
				selectRow(i, 1);
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	// 어느 행을 터뜨릴지 선택하는 메서드, 열 입력을 바탕으로 목표인 (행, 열)을 찾고 터뜨림
	private static void selectRow(int col, int count) {
		
		
		// 해당 열 중에서 가장 높은 행을 받음 (가장 작은 행을 받음)
		int aimRow = -1; 
		
		for (int r = 0; r<H; r++) {
			if (map[r][col] > 0) {
				aimRow = r;
				break;
			}
		}
		
		// 만약 해당 열이 비어있다면, 부술게 없으므로 리턴
		if (aimRow == -1) return;
		
		// 맵에서 블록을 파괴하기 전에 백업해놓기
		int[][] backup = new int[H][W];
		int backupBlocks = blocks;
		
		for (int c = 0; c<W; c++) {
			for (int r = H-1; r>=0; r--) {
				if (map[r][c] > 0) backup[r][c] = map[r][c];
				else break;
			}
		}
		
		// 부수기실행
		// 첫 목표의 x,y좌표  : (aimRow, col) 
		breakBlock(aimRow, col);
		
		// 블럭들 내리기
		downBlock();
		
		// 최적값인지 갱신
		if (ans > blocks) ans = blocks;
		
		// 다음 부수기 시작
		if (count < N) {
			for (int i = 0; i<W; i++) {
				selectRow(i, count+1);
			}
		}
		
		// 맵 복구
		map = backup;
		blocks = backupBlocks;
		
	}

	// 블럭을 밑으로 내리는 메서드
	private static void downBlock() {
		for (int c = 0; c<W; c++) {
			int index = H-1;
			for (int r = H-1; r>=0; r--) {
				if (map[r][c] == 0) continue;
				else if (r == index) index--;
				else {
					map[index--][c] = map[r][c];
					map[r][c] = 0;
				}
			}
		}
		
	}

	// 블럭을 부수는 메서드, BFS를 이용한다
	private static void breakBlock(int r, int c) {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.offer(new int[] {r, c, map[r][c]});
		map[r][c] = 0;
		blocks--;
		
		while(!queue.isEmpty()) {
			int[] out = queue.poll();
			int x = out[0];
			int y = out[1];
			int power = out[2];
			if (power == 1) continue;
			
			for (int dir = 0; dir<4; dir++) {
				for (int i = 1; i<power; i++) {
					if (inMap(x+dx[dir]*i, y+dy[dir]*i)) {
						if (map[x+dx[dir]*i][y+dy[dir]*i] > 0) {
							queue.offer(new int[] {x+dx[dir]*i, y+dy[dir]*i, map[x+dx[dir]*i][y+dy[dir]*i]});
							blocks--;
							map[x+dx[dir]*i][y+dy[dir]*i] = 0;
						} 
					} else break;
				}
				
			}
		}
		
	}
	
	// 부수려는 곳이 맵 밖인지 체크하는 메서드
	private static boolean inMap(int x, int y) {
		return (x < H && y < W && x >= 0 && y >= 0);
	}
}
