package day0330;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1238_Contact {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = 10;
		for (int tc = 1; tc<=testCase; tc++) {
			
			// N개 만큼의 데이터가 들어오고
			// 시작 노드의 인덱스는 start
			int N = sc.nextInt();
			int start = sc.nextInt();
			
			// 각 노드의 번호는 꼭 1~N인것은 아니고
			// 1부터 100까지의 자연수이며, 중간에 비어있을 수도 있으므로
			// 노드 사이의 간선이 있는지 체크하는 배열 edges는 그 크기를 101로 만들어서 1부터 100까지 체크가 되게 한다
			ArrayList<Integer>[] edges = new ArrayList[101];
			// 방문 확인용 배열
			int[] visited = new int[101];
			
			// 만약 A B 가 주어지면 A -> B 간선이 있다는 것이므로 이를 저장
			for (int i = 0; i<N/2; i++) {
				int in = sc.nextInt();
				int out = sc.nextInt();
				if (edges[in] == null) edges[in] = new ArrayList<>();
				edges[in].add(out);
			}
			
			// 방문을 순서대로 처리하기 위한 큐
			Queue<Integer> queue = new LinkedList<Integer>();
			
			// 맨 처음 시작 노드를 넣고 출발.
			// 시작 노드의 방문 값은 1로 줌
			queue.offer(start);
			visited[start] = 1;
			
			// 맨 앞에 있는 노드를 뽑고
			while(!queue.isEmpty()) {
				int out = queue.poll();
				
				// 만약 간선이 없다면, 다음 노드를 뽑음
				if (edges[out] == null) continue;
				
				// 만약 간선이 있고, 이 간선이 이미 방문되지 않은 노드와 이어지는 간선이라면
				// 방문되지 않은 노드는 현재 노드보다 1만큼의 시간이 더 걸려서 방문하는 것이다.
				for (int i : edges[out]) {
					if (visited[i] > 0) continue;
					visited[i] = visited[out] + 1;
					queue.offer(i);
				}
			}
			
			// 따라서 , 최대 시간이 걸려 탐색된 노드의 최대 인덱스를 출력하면 된다.
			int max = 0;
			int maxIdx = 0;
			
			for (int i = 1; i<=100; i++) {
				if (max <= visited[i]) {
					max = visited[i];
					maxIdx = i;
				}
			}
			System.out.println("#"+tc+" "+maxIdx);
		}
	}
}
