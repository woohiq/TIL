import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt(); // 정점개수 (0 ~ N-1)
		int E = sc.nextInt(); // 간선개수
		
		p = new int[V];
		
		for (int i = 0; i<V; i++) {
			p[i] = i;
		}
		
		// 0 : 시작점 
		// 1 : 도착점
		// 2 : 가중치
		int[][] edges = new int[E][3];
		for (int i = 0; i<E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		// 크루스칼 1단계 : 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// 크루스칼 2단계 : V-1개 간선 뽑는데 사이클 검사
		int count = V-1;
		int ans = 0;
		for (int i = 0; i<E; i++) {
			// int px = findSet(x);
			// int py = findSet(y);
			if (findSet(edges[i][0]) != findSet(edges[i][1])) {
				// if (px != py){
				ans += edges[i][2];
				count--;
				Union(edges[i][0], edges[i][1]);
				// Union(px, py);
			}
			if (count == 0) break;
		}
		if (count == 0) System.out.println(ans);
		else System.out.println(-1);
	}
	public static int findSet(int x) {
		if (x == p[x]) return x;
		else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}
	public static void Union(int x, int y) {
		p[findSet(y)] = findSet(x);
		// p[y] = x;
	}
}
