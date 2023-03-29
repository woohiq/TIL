package day0329;
import java.io.IOException;
import java.util.Scanner;

public class SWEA_3289_서로소집합 {
	static int[] p, rank;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int testCase= sc.nextInt();
		
		for (int tc = 1; tc<=testCase; tc++) {
			System.out.print("#"+tc+" ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 각 노드의 부모 나타내는 배열 p
			// 각 노드의 자식 개수를 나타내는 (rank) rank
			p = new int[N+1];
			rank = new int[N+1];
			
			for (int i = 1; i<=N; i++) {
				p[i] = i;
			}
			
			// px 와 py이라는 대표자를 받아와서
			// 만약 대표자가 같으면 같은 그룹
			// 대표자가 다르면 다른 그룹
			for (int i = 0; i<M; i++) {
				int cmd = sc.nextInt();
				int px = findSet(sc.nextInt());
				int py = findSet(sc.nextInt());
				if (cmd == 0) {
					Union(px, py);
				} else {
					int output = (px==py) ? 1 : 0;
					System.out.print(output);
				}
			}
			System.out.println();
		}
	}
	
	// 수업시간에 배운 findset, union
	public static int findSet(int x) {
		if (x == p[x]) return x;
		else p[x] = findSet(p[x]);
		return p[x];
	}
	public static void Union(int px, int py) {
		if (rank[px] > rank[py]) {
			p[py] = px;
			return;
		}
		p[px] = py;
		rank[py] = Math.max(rank[px]+1, rank[py]);
	}
}
