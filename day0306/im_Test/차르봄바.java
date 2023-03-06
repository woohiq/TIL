package im_Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 차르봄바 {
	
	public static int N;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc<testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			for (int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					int tmp =  map[i][j];
					System.out.println(tmp);
					here: for (int k = 0; k<4; k++) {
						int cnt = P;
						int tmpI = i;
						int tmpJ = j;
						while(cnt > 0) {
							cnt--;
							if (!inBorder(tmpI + dx[k] , tmpJ + dy[k])) continue here;
							tmpI += dx[k];
							tmpJ += dy[k];
							tmp += map[tmpI][tmpJ];
						}
					}
					System.out.println(i+" "+j+" "+tmp);
					if (tmp > max) max = tmp;
					
				}
			}
			System.out.println("#"+(tc+1)+" "+max);
			
			
		}
	}
	
	public static boolean inBorder(int x, int y) {
		return (x >= 0 && y >= 0 && x < N && y < N);
	}
}