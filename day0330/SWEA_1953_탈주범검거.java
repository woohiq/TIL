package day0330;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1953_탈주범검거 {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 기본적인 아이디어는 BFS를 쓰되,
		 * 현재 위치의 파이프에서 출발할 수 있는 방향과
		 * 도착 위치의 파이프로 도착 할 수 있는 방향을 고려해서
		 * 둘 다 만족하면 방문가능
		 */
		int testCase = sc.nextInt();
		
		// 0 : 좌
		// 1 : 상
		// 2 : 우
		// 3 : 하
		int[] dx = new int[] {0, -1, 0, 1};
		int[] dy = new int[] {-1, 0, 1, 0};
		
		for (int tc = 1; tc<=testCase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int time = sc.nextInt();
			
			// map 배열 선언, 방문체크용 배열 isVisited
			int[][] map = new int[N][M];
			boolean[][] isVisited = new boolean[N][M];
			
			// map 배열 채우기
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			Queue<int[]> queue = new LinkedList<int[]>();
			
			// BFS 시작, 첫 노드는 맨왼쪽위 좌표
			queue.offer(new int[] {startX, startY, 0});
			isVisited[startX][startY] = true;
			int Cnt = 1;
			
			while(!queue.isEmpty()) {
				int[] out = queue.poll();
				int X = out[0];
				int Y = out[1];
				int tmpTime = out[2] + 1;
				
				// 주어진 시간을 벗어나면 break
				if (tmpTime >= time) break;
				
				// 방문 가능 판정 
				// 1. 해당 위치에서 출발 가능한 방향
				// 2. 도착 위치에 방문한 적 없음
				// 3. 도착 위치로 도착 가능한 방향
				for (int a = 0; a<4; a++) {
					if (canStart(a, map[X][Y])) {
						if (inMap(X+dx[a], Y+dy[a]) && canArrive(a, map[X+dx[a]][Y+dy[a]]) && !isVisited[X+dx[a]][Y+dy[a]]) {
							isVisited[X+dx[a]][Y+dy[a]] = true;
							Cnt++;
							queue.offer(new int[] {X+dx[a], Y+dy[a], tmpTime});
						}
					}
				}
			}
			System.out.println("#"+tc+" "+Cnt);
		}
	}
	private static boolean inMap(int i, int j) {
		return (i<N && j<M && i>=0 && j>=0);
	}
	
	// 출발, 도착 가능 판정 메서드
	private static boolean canArrive(int move, int status) {
		return (status == 1 || status == (3-move%2) || status == (move+4) || status == (4+(move+1)%4));
	}
	private static boolean canStart(int move, int status) {
		return (status == 1 || status == (3-move%2) || status == (4+(move+2)%4) || status == (4+(move+3)%4));
	}
}
