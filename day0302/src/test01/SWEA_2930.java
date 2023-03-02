package test01;

import java.util.Scanner;

public class SWEA_2930 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			sb.append("#"+(tc+1));
			int N = sc.nextInt();
			int[] heap = new int[N+1];
			int size = 0;
			
			for (int i = 0; i<N; i++) {
				int command = sc.nextInt();
				if (command == 1) {
					int input = sc.nextInt();
					heap[++size] = input;
					int cur = size;
					while(cur > 1 && heap[cur] > heap[cur/2]) {
						int tmp = heap[cur];
						heap[cur] = heap[cur/2];
						heap[cur/2] = tmp;
						cur/=2;
						
					}
				} else if (command == 2) {
					if (size == 0) sb.append(" "+-1);
					else {
						sb.append(" "+heap[1]);
						heap[1] = heap[size--];
						int cur = 1;
						while(cur <= size/2 && (heap[cur] < heap[cur*2] || heap[cur] < heap[cur*2+1])) {
							int max = (heap[cur*2]<heap[cur*2+1]) ? cur*2+1 : cur*2;
							int tmp = heap[cur];
							heap[cur] = heap[max];
							heap[max] = tmp;
							cur = max;
							
						}
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
