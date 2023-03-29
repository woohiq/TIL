package day0329;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7465_창용마을무리의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc<=testCase; tc++) {
			
			// 사람의 수 N
			// 관계의 수 M
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 서로 아는 사이인지 정보를 담는 배열
			boolean[][] isFriend = new boolean[N+1][N+1];
			
			// A와 B가 친구라면
			// A -> B 
			// B -> A 
			// 두 가지 접근 모두 가능
			for (int i = 0; i<M; i++) {
				int one = sc.nextInt();
				int two = sc.nextInt();
				isFriend[one][two] = true;
				isFriend[two][one] = true;
			}
			
			// 이미 무리에 속해있는지 정보를 담는 배열
			boolean[] inTown = new boolean[N+1];
			
			int ans = 0;
			Queue<Integer> queue = new LinkedList<Integer>();
			
			/*
				1번 사람부터 돌면서
				
				어느 마을에 소속되었으면 → 이미 고려되었음 continue
				어느 마을에도 소속되지 않음 → `고려 시작`
				대신 현재 사람과 친구인 사람들을 모두 마을에 소속
				그 친구의 친구도 마을에 소속 
				(Queue를 이용한 BFS탐색으로)
				
				위의 방법을 이용해 `고려시작` 횟수가 `무리의 개수` 이다
			 */
			for (int i = 1; i<=N; i++) {
				if (!inTown[i]) {
					ans++;
					inTown[i] = true;
					queue.offer(i);
				}
				while(!queue.isEmpty()) {
					int out = queue.poll();
					for (int j = 1; j<=N; j++) {
						if (isFriend[out][j] && !inTown[j]) {
							inTown[j] = true;
							queue.offer(j);
						}
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
