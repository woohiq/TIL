package day0330;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class dijkstra {
	
	static class Node {
		int v, w;
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	static final int INF = 2147483647;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for (int i = 0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		for (int i = 0; i<E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjList[A].add(new Node(B, W));
		}
		
		dijkstra(0);
		
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[V];
		
		dist[start] = 0;
		for (int i = 0; i<V-1; i++) {
			int min = INF;
			int idx = -1;
			for (int j = 0; j<V; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			if (idx == -1) break; // 경로 찾지 못함
			
			visited[idx] = true;
			for (int j = 0; j<adjList[idx].size(); j++) {
				Node curr = adjList[idx].get(j);
				
				if (!visited[curr.v] && curr.w + min < dist[curr.v]) {
					dist[curr.v] = curr.w + min;
					visited[curr.v] = true; 
				}
			}
		}
	}
}
