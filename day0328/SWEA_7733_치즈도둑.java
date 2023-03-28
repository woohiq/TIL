import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7733_치즈도둑 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 입력받기
		int testCase = sc.nextInt();
		
		// 델타 탐색용 배열 선언
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		for (int tc = 1; tc<=testCase; tc++) {
			N = sc.nextInt();
			
			// 맵 정보 입력받기
			// map[i][j] : i행 j열에 담겨져 있는 치즈의 맛있는 정도
			int[][] map = new int[N][N];
			
			int tmpMax = 0;
			
			for (int i = 0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					int tmp = sc.nextInt();
					map[i][j] = tmp;
					if (tmp > tmpMax) tmpMax = tmp;
				}
			}
			
			int max = 0;
			
			// 시간을 0부터 99까지 탐색하며 가장 많은 조각을 찾기
			for (int time = 0; time<tmpMax; time++) {
				
				// BFS 탐색용 방문체크 isVisited 배열과 queue 선언
				boolean[][] isVisited = new boolean[N][N];
				Queue<int[]> queue = new LinkedList<int[]>();
				
				// count : 조각의 개수
				int count = 0;
				
				// 모든 행과 열을 돌면서 아직 방문이 안된 노드 : 새로운 조각
				// 새로운 조각과 이어지는 모든 노드들을 방문함
				for (int i = 0; i<N; i++) {
					for (int j = 0; j<N; j++) {
						if (map[i][j] > time && !isVisited[i][j]) {
							count++;
							isVisited[i][j] = true;
							queue.offer(new int[] {i, j});
							
							while(!queue.isEmpty()) {
								int[] out = queue.poll();
								int X = out[0];
								int Y = out[1];
								for (int a = 0; a<4; a++) {
									if (inMap(X+dx[a], Y+dy[a]) && map[X+dx[a]][Y+dy[a]] > time && !isVisited[X+dx[a]][Y+dy[a]]) {
										isVisited[X+dx[a]][Y+dy[a]] = true;
										queue.offer(new int[] {X+dx[a], Y+dy[a]});
									}
								}
							}
						}
					}
				}
				// 최대값 갱신
				if (count > max) max = count;
			}
			System.out.println("#"+tc+" "+max);
		}
	}

	private static boolean inMap(int x, int y) {
		return (x < N && y < N && x >= 0 && y >= 0);
	}
}
