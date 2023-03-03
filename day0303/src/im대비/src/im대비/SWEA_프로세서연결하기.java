package im대비;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SWEA_프로세서연결하기 {
	
	public static int N;
	public static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			
			int cnt = 0;
			
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					int in = sc.nextInt();
					if (in == 0) map[i][j] = 0;
					else map[i][j] = ++cnt;
				}
			}
			
			cnt = 0;
			
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					if (map[i][j] != 0 && inBorder(i,j,N)) {
						map[i][j] = -1;
					}
				}
			}
			
			int[] dx = new int[] {0, 0, 1, -1};
			int[] dy = new int[] {1, -1, 0, 0};
			
			for (int i = 1; i<N; i++) {
				for (int j = i; j<N-i; j++) {
					for (int k = i; k<N-i; k++) {
						if (map[j][k] != 0 && inBorder(i, j, N-i)) {
							boolean flag = false;
							here: for (int l = 0; l<4; l++) {
								int tmpI = j;
								int tmpJ = k;
								
								int count = i;
								
								while(count-- > 0) {
									tmpI += dx[l];
									tmpJ += dy[l];
									if (map[tmpI][tmpJ] != 0) continue here;
								}
								
								if (!inBorder(tmpI, tmpJ, N)) continue;
								flag = true;
								break;
							}
							if (flag) {
								map[j][k] = -1;
								cnt += i;
							}
						}
					}
				}
			}
			
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					if (map[i][j] == 0) {
						int stk = 0;
						int[] hit = new int[2];
						for (int k = 0; k<4; k++) {
							int tmpI = i;
							int tmpJ = j;
							while(!inBorder(tmpI, tmpJ, N)) {
								if (map[tmpI][tmpJ] > 0) {
									hit[stk++] = map[tmpI][tmpJ];
									hit[stk+1] = 
									break;
								}
							}
							if (stk > 1) {
								
							}
						}
					}
				}
			}
			
			
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					System.out.printf("%3d ",map[i][j]);
				}
				System.out.println();
			}
			System.out.println(cnt);
		}
			
		
	}
	public static boolean inBorder(int x, int y, int t) {
		return (x == N-t || y == N-t || x == t-1 || y == t-1);
	}
	
}
