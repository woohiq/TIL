package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		BambooForest[] forest = new BambooForest[N*N];
		BambooForest[] forestUnsorted = new BambooForest[N*N];
		
		int forestCnt = 0;
		
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j<N; j++) {
				BambooForest newForest = new BambooForest(i, j, Integer.parseInt(st.nextToken()));
				forestUnsorted[forestCnt] = newForest;
				forest[forestCnt++] = newForest;
			}
		}
		
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		Arrays.sort(forest);
		
		int ans = 0;
		
		for (int i = 0; i<N*N; i++) {
			BambooForest cur = forest[i];
			int x = cur.x;
			int y = cur.y;
			int amount = cur.amount;
			for (int a = 0; a<4; a++) {
				if (inMap(x+dx[a], y+dy[a]) && forestUnsorted[(x+dx[a]) * N + y+dy[a]].amount < amount) {
					cur.count = Math.max(cur.count, forestUnsorted[(x+dx[a]) * N + y+dy[a]].count + 1);
				}
			}
			ans = cur.count > ans ? cur.count : ans;
		}
		System.out.println(ans);
	}
	
	private static boolean inMap(int i, int j) {
		return ( i < N && j < N && i >= 0 && j >= 0);
	}
}
class BambooForest implements Comparable<BambooForest>{
	int x;
	int y;
	int amount;
	int count;
	
	public BambooForest(int x, int y, int amount) {
		this.x = x;
		this.y = y;
		this.amount = amount;
		this.count = 1;
	}

	@Override
	public int compareTo(BambooForest o) {
		return this.amount - o.amount;
	}
}
