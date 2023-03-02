package Algorithm;

import java.util.Scanner;

public class SWEA_1873 {
	
	public static int H, W;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int testCase = sc.nextInt();
		
		for (int tc = 0; tc<testCase; tc++) {
			sb.append("#"+(tc+1)+" ");
			
			H = sc.nextInt();
			W = sc.nextInt();
			sc.nextLine();
			
			char[][] grid = new char[H][W];
			
			int tankX = 0;
			int tankY = 0;
			char tankStatus = '\u0000';
			
			for (int i = 0; i<H; i++) {
				String str = sc.nextLine();
				for (int j = 0; j<W; j++) {
					char tmp = str.charAt(j);
					grid[i][j] = tmp;
					if (tmp == '<' || tmp == '>' || tmp == '^' || tmp == 'v') {
						tankX = i;
						tankY = j;
						tankStatus = tmp;
					}
				}
			}
			
			int command = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			
			for (int i = 0; i<command; i++) {
				int cur = str.charAt(i);
				if (cur == 'U') {
					tankStatus = '^';
					grid[tankX][tankY] = tankStatus;
					int deltaIdx = 0;
					if (inGrid(tankX+dx[deltaIdx],tankY+dy[deltaIdx]) && grid[tankX+dx[deltaIdx]][tankY+dy[deltaIdx]] == '.') {
						grid[tankX][tankY] = '.';
						tankX = tankX+dx[deltaIdx];
						tankY = tankY+dy[deltaIdx];
						grid[tankX][tankY] = tankStatus;
					}
				} else if (cur == 'D') {
					tankStatus = 'v';
					grid[tankX][tankY] = tankStatus;
					int deltaIdx = 1;
					if (inGrid(tankX+dx[deltaIdx],tankY+dy[deltaIdx]) && grid[tankX+dx[deltaIdx]][tankY+dy[deltaIdx]] == '.') {
						grid[tankX][tankY] = '.';
						tankX = tankX+dx[deltaIdx];
						tankY = tankY+dy[deltaIdx];
						grid[tankX][tankY] = tankStatus;
					}
				} else if (cur == 'L') {
					tankStatus = '<';
					grid[tankX][tankY] = tankStatus;
					int deltaIdx = 2;
					if (inGrid(tankX+dx[deltaIdx],tankY+dy[deltaIdx]) && grid[tankX+dx[deltaIdx]][tankY+dy[deltaIdx]] == '.') {
						grid[tankX][tankY] = '.';
						tankX = tankX+dx[deltaIdx];
						tankY = tankY+dy[deltaIdx];
						grid[tankX][tankY] = tankStatus;
					}
				} else if (cur == 'R') {
					tankStatus = '>';
					grid[tankX][tankY] = tankStatus;
					int deltaIdx = 3;
					if (inGrid(tankX+dx[deltaIdx],tankY+dy[deltaIdx]) && grid[tankX+dx[deltaIdx]][tankY+dy[deltaIdx]] == '.') {
						grid[tankX][tankY] = '.';
						tankX = tankX+dx[deltaIdx];
						tankY = tankY+dy[deltaIdx];
						grid[tankX][tankY] = tankStatus;
					}
				} else if (cur == 'S') {
					int deltaIdx = 0;
					if (tankStatus == 'v') deltaIdx = 1;
					else if (tankStatus == '<') deltaIdx = 2;
					else if (tankStatus == '>') deltaIdx = 3;
					
					int X = tankX+dx[deltaIdx];
					int Y = tankY+dy[deltaIdx];
					
					while(inGrid(X,Y)) {
						if (grid[X][Y] == '*' || grid[X][Y] == '#') {
							if (grid[X][Y] == '*') grid[X][Y] = '.';
							break;
						} else {
							X += dx[deltaIdx];
							Y += dy[deltaIdx];
						}
					}
				}
			}
			for (int i = 0; i<H; i++) {
				for (int j = 0; j<W; j++) {
					sb.append(grid[i][j]);
				}
				sb.append("\n");
			}
			
		}
		System.out.print(sb);
	}
	
	public static boolean inGrid(int x, int y) {
		return (x >= 0 && y >= 0 && x < H && y < W);
	}
}
