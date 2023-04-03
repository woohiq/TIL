import java.util.Scanner;

public class SWEA_5650_핀볼게임 {
	static int[][] map, wormhole;
	static int ans;
	static int[] dx = new int[] {0, 1, 0, -1};
	static int[] dy = new int[] {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc<=testCase; tc++) {
			int N = sc.nextInt();
			
			/* 
			 * map, 웜홀 입력받기
			 * 
			 * map은 N+2 * N+2 사이즈 배열로 선언하여
			 * 최외곽을 '5' 블럭으로 채운다 
			 * (왜냐하면 밖으로 나가면 다시 튕겨저 들어오는 게 블럭 5의 역할과 동일하기 때문)
			 * 
			 *  그리고 웜홀 (원소가 6이상 10이하인 경우) 의 정보를 
			 *  wormhole 배열에 저장
			 */
			map = new int[N+2][N+2];
			wormhole = new int[11][4];
			ans = 0;
			for (int i = 0; i<N+2; i++) {
				for (int j = 0; j<N+2; j++) {
					// 최외곽은 5 블럭으로 채움
					if (i == 0 || j == 0 || i == N+1 || j == N+1) {
						map[i][j] = 5;
						continue;
					}
					// 안쪽은 map 배열을 해당 입력으로 채움
					int tmp = sc.nextInt();
					if (tmp > 5) {
						if (wormhole[tmp][0] > 0) {
							wormhole[tmp][2] = i;
							wormhole[tmp][3] = j;
						} else {
							wormhole[tmp][0] = i;
							wormhole[tmp][1] = j;
						}
					}
					map[i][j] = tmp;
				}
			}
			
			// 전체탐색 시작
			// 모든 map (N * N 배열에 대해 모든 방향 (4방향) 탐색)
			for (int i = 1; i<=N; i++) {
				for (int j = 1; j<=N; j++) {
					if (map[i][j] == 0) {
						for (int a = 0; a<4; a++) {
							start(i, j, a);
						}
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void start(int x, int y, int dir) {
		// x : 시작 x좌표
		// y : 시작 y좌표
		// dir : 이동 방향 ( 우, 하, 좌, 상 )
		int tmp = 0;
		int tmpX = x;
		int tmpY = y;
		
		// 해당 방향으로 이동해서
		// 해당 방향이 출발 위치라면 종료
		// 해당 방향이 0이라면 ( 비어있다면 ) 방향을 바꾸지 않고 진행
		// 해당 방향에 블럭이 있다면 (1~5) 블럭에 따라 방향을 바꿈, 점수 +1
		// 해당 방향에 웜홀이 있다면 (6~10) 웜홀의 다른 출구로 나옴
		// 해당 방향에 블랙홀이 있다면 (-1) 종료
		while(true) {
			
			// 해당 방향으로 이동
			tmpX += dx[dir];
			tmpY += dy[dir];
			
			// 출발 위치라면 종료
			if (tmpX == x && tmpY == y) {
				return;
			}
			
			// 비어있다면 방향을 바꾸지 않고 계속 진행
			if (map[tmpX][tmpY] == 0) {
				continue;
				
				// 블럭이 있다면 튕김 (1)
			} else if (map[tmpX][tmpY] == 1+(dir+2)%4) {
				if (++tmp > ans) ans = tmp;
				dir = (dir+1)%4;
				
				// 블럭이 있다면 튕김 (2)
			} else if (map[tmpX][tmpY] == 1+(dir+3)%4) {
				if (++tmp > ans) ans = tmp;
				dir = (dir+3)%4;
				
				// 웜홀이 있다면 웜홀의 다른 출구로 나옴
			} else if (map[tmpX][tmpY] > 5 ) {
				int temp = map[tmpX][tmpY];
				if (tmpX == wormhole[temp][0] && tmpY == wormhole[temp][1]) {
					tmpX = wormhole[temp][2];
					tmpY = wormhole[temp][3];
				} else {
					tmpX = wormhole[temp][0];
					tmpY = wormhole[temp][1];
				}
				
				// 블랙홀이 있다면 종료
			} else if (map[tmpX][tmpY] == -1) {
				return;
				
				// 블럭이 있다면 튕김 (3)
			} else {
				if (++tmp > ans) ans = tmp;
				dir = (dir+2)%4;
			}
 		}
	}
}
