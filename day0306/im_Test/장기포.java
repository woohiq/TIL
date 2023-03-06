package im_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장기포 {
	
	public static int N;
	public static int[][] map;
	public static boolean[][] take;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc<testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			
			int initX = 0;
			int initY = 0;
			
			for (int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j<N; j++) {
					int in = Integer.parseInt(st.nextToken());
					if (in == 2) {
						initX = i;
						initY = j;
					}
					map[i][j] = in;
				}
			}
			take = new boolean[N][N];
			move(0, initX, initY);
			int ans = 0;
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					if (take[i][j]) ans++;
				}
			}
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					if (take[i][j]) System.out.print("O ");
					else System.out.print("X ");
				}
				System.out.println();
			}
			System.out.println("#"+(tc+1)+" "+ans);
			
		}
	}
	
	public static void move(int cnt, int X, int Y) {
		if (cnt == 3) return;
		else {
			here: for (int i = 0; i<4; i++) {
				int tmpX = X;
				int tmpY = Y;
				while(inGrid(tmpX + dx[i], tmpY + dy[i])) {
					tmpX += dx[i];
					tmpY += dy[i];
					if (map[tmpX][tmpY] == 1) break;
				}
				if (!inGrid(tmpX + dx[i], tmpY + dy[i])) continue here;
				while(inGrid(tmpX + dx[i], tmpY + dy[i])) {
					tmpX += dx[i];
					tmpY += dy[i];
					if (map[tmpX][tmpY] == 0 || map[tmpX][tmpY] == 2) {
						move(cnt+1, tmpX, tmpY);
					}
					if (map[tmpX][tmpY] == 1) {
						take[tmpX][tmpY] = true;
						map[tmpX][tmpY] = 0;
						move(cnt+1, tmpX, tmpY);
						map[tmpX][tmpY] = 1;
						break;
					}
				}
			}
		}
	}
	
	public static boolean inGrid (int x, int y) {
		return (x >= 0 && y >= 0 && x < N && y < N);
	}
}