package day0329;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA_1251_하나로 {
	static int[] p, rank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc<=testCase; tc++) {
			int N = sc.nextInt();
			
			// 자신의 대표자를 나타내는 배열 p
			// 자신의 자식의 개수 (rank) 를 나타내는 배열 rank
			p = new int[N];
			rank = new int[N];
			
			// 모든 섬의 x좌표와 y좌표를 입력받음
			// island[i][0] : i번째 섬의 x좌표
			// island[i][1] : i번째 섬의 y좌표
			int[][] islands = new int[N][2];
			for (int i = 0; i<N; i++) {
				islands[i][0] = sc.nextInt();
			}
			for (int i = 0; i<N; i++) {
				islands[i][1] = sc.nextInt();
			}
			
			double E = sc.nextDouble();
			
			// 어느 두 섬이라도 다리를 만들 수 있다.
			// 최대 간선
			double[][] edges = new double[N*(N-1)/2][3];
			
			int cnt = 0;
			for (int i = 0; i<N-1; i++) {
				for (int j = i+1; j<N; j++) {
					edges[cnt][0] = (double)i;
					edges[cnt][1] = (double)j;
					edges[cnt++][2] = (Math.pow(islands[i][0] - islands[j][0], 2) + Math.pow(islands[i][1] - islands[j][1], 2)) * E;
				}
			}
			
			Arrays.sort(edges, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					if (o1[2] >= o2[2]) return 1;
					return -1;
				}
			});
			
			for (int i = 0; i<N; i++) {
				p[i] = i;
			}
			
			double ans = 0;
			int count = N-1;
			
			for (int i = 0; i<cnt; i++) {
				int px = findSet((int)edges[i][0]);
				int py = findSet((int)edges[i][1]);
				
				if (px != py) {
					count--;
					ans += edges[i][2];
					Union(px, py);
				}
				if (count == 0) break;
			}
			if (count == 0) System.out.printf("#%d %.0f\n", tc, ans);
			else System.out.println("#"+tc+" "+-1);
		}
	}
	public static int findSet(int x) {
		if (x == p[x]) return x;
		else p[x] = findSet(p[x]);
		return p[x];
	}
	public static void Union(int x, int y) {
		if (rank[x] > rank[y]) {
			p[y] = x;
			return;
		}
		p[x] = y;
		rank[y] = Math.max(rank[y], rank[x]+1);
		return;
	}
}
