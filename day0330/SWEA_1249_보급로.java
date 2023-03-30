package day0330;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1249_보급로 {
	static int N;
	static int[] dx = new int[] {1, 0, -1, 0};
	static int[] dy = new int[] {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * BFS를 Queue 대신 PriorityQueue를 쓴다면
		 * 가장 복구시간이 짧은 경로부터 탐색 할 수 있을 것이다
		 */
		int testCase = sc.nextInt();
		tcLoop: for(int tc = 1; tc<=testCase; tc++) {
			N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i<N; i++) {
				String tmp = sc.next();
				for (int j = 0; j<N; j++) {
					map[i][j] = tmp.charAt(j)-'0';
				}
			}
			
			// Priority Queue, 입력에 대해 가장 복구시간이 짧은 것부터 내보낸다
			PriorityQueue<int[]> queue = new PriorityQueue<>((int[] o1, int[] o2) -> {
				return o1[2] - o2[2];
			});
			
			// 방문 체크
			boolean[][] isVisited = new boolean[N][N];
			queue.offer(new int[] {0, 0, 0});
			
			// BFS 시작~
			while(!queue.isEmpty()) {
				int[] out = queue.poll();
				int X = out[0];
				int Y = out[1];
				int cnt = out[2];
				
				// 방문 가능하다면 , 방문
				for (int a = 0; a<4; a++) {
					if (inMap(X+dx[a], Y+dy[a]) && !isVisited[X+dx[a]][Y+dy[a]]) {
						
						// 만약 마지막 도로에 도착했다면, 끝~
						if (X+dx[a] == N-1 && Y+dy[a] == N-1) {
							System.out.println("#"+tc+" "+cnt);
							continue tcLoop;
						}
						isVisited[X+dx[a]][Y+dy[a]] = true;
						queue.offer(new int[] {X+dx[a], Y+dy[a], cnt+map[X+dx[a]][Y+dy[a]]});
					}
				}
			}
		}
	}
	public static boolean inMap(int x, int y) {
		return (x<N && y<N && x>=0 && y>=0);
	}
}
