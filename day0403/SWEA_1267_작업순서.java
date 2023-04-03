import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1267_작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		for (int tc = 1; tc<=10; tc++) {
			// 입력 받기
			sb.append("#"+tc);
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			// 인접 리스트 edges 선언
			// 들어오는 간선의 개수 정보를 담은 배열 indegree 선언
			List<Integer>[] edges = new ArrayList[V+1];
			int[] indegree = new int[V+1];
			
			// 인접 리스트 입력 받기
			for (int i = 0; i<E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if (edges[start] == null) edges[start] = new ArrayList<>();
				edges[start].add(end);
				indegree[end]++;
			}
			
			// Queue를 이용해 위상 정렬 
			Queue<Integer> queue = new LinkedList<>();
			
			// 만약 들어오는 간선의 개수가 없다면, 처음으로 실행 될 수 있음
			for (int i = 1; i<=V; i++) {
				if (indegree[i] == 0) {
					queue.offer(i);
					sb.append(" "+i);
				}
			}
			
			// 만약 들어오는 간선의 개수가 없어진다면, 실행 될 수 있음
			while(!queue.isEmpty()) {
				int tmp = queue.poll();
				if (edges[tmp] == null) continue;
				for (int i : edges[tmp]) {
					if (--indegree[i] == 0) {
						queue.offer(i);
						sb.append(" "+i);
					}
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
