package day0330;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1251_하나로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc<=testCase; tc++) {
			int N = sc.nextInt();
			
			// 각 섬 x y 좌표 입력받기
			int[][] islands = new int[N][2];
			for (int i = 0; i<N; i++) {
				islands[i][0] = sc.nextInt();
			}
			for (int i = 0; i<N; i++) {
				islands[i][1] = sc.nextInt();
			}
			
			// 환경 부담 세율 실수
			double E = sc.nextDouble();
			
			// 각 터널의 가격을 인접리스트로 나타냄
			// i번째 섬과 j번째 섬까지의 터널의 가격은 tunnels[i][j] or tunnels[j][i]
			double[][] tunnels = new double[N][N];
			
			// 각 터널마다의 가격 계산
			// 자기자신으로의 터널가격은 무한대 (만들 수 없으므로)
			// 다른 터널로의 가격은 거리의 제곱에 세율을 곱한 수
			for (int i = 0; i<N; i++) {
				tunnels[i][i] = Double.MAX_VALUE;
			}
			for (int i = 0; i<N; i++) {
				for (int j = i+1; j<N; j++) {
					tunnels[i][j] = E*(Math.pow(islands[i][0]-islands[j][0], 2)+Math.pow(islands[i][1]-islands[j][1], 2));
					tunnels[j][i] = tunnels[i][j];
				}
			}
			
			// 우선순위 큐로 실행시간 복잡도를 낮추겠다
			PriorityQueue<double[]> pq = new PriorityQueue<>((double[] o1,double[] o2) -> {
				if (o1[2] > o2[2]) return 1;
				else if (o1[2] == o2[2]) return 0;
				else return -1;
			});
			
			// 방문 여부 확인 배열 visited
			boolean[] visited = new boolean[N];
			
			// 0부터 방문 시작
			// 0과 연결된 간선들을 큐에 넣기
			visited[0] = true;
			for (int j = 1; j<N; j++) {
				pq.offer(new double[] {0, j, tunnels[0][j]});
			}
			double ans = 0;
			int pick = 1;
			
			// 다 뽑거나 (성공)
			// 큐가 비거나 (실패) 할때까지 실행
			// 문제에서 실패하는 경우는 없다고 보장했지만, 혹시 모르니까
			while(pick < N && !pq.isEmpty()) {
				
				// 이미 방문한 곳에 다리를 놓지 않는다
				double[] tmp = pq.poll();
				if (visited[(int)tmp[1]]) continue;
				
				// 방문하지 않은 곳은 방문한다
				int cur = (int)tmp[1];
				pick++;
				visited[cur] = true;
				ans += tmp[2];
				
				// 방금 방문한 곳의 간선들을 모두 큐에 넣기
				// 이미 방문한곳의 간선은 넣을 필요가 없다
				for (int j = 1; j<N; j++) {
					if (!visited[j]) {
						pq.offer(new double[] {cur, j, tunnels[cur][j]});
					}
				}
				
			}
			System.out.printf("#%d %.0f\n", tc, ans);
			
		}
	}
}
