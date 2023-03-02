package test01;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
	static int[] arr;
	static int lastIdx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int lastIdx = 0;
		
		for (int i = 0; i<N; i++) {
			System.out.println("#"+(i+1));
			int c = sc.nextInt();
			if (c == 1) {
				
				int num = sc.nextInt();
				arr[++lastIdx] = num;
				int cur = lastIdx;
				
				while(cur>1 && arr[cur] > arr[cur/2]) {
					swap(cur,cur/2);
					cur /= 2;
				}
				
			} else if (c == 2) {
				System.out.println(" " + arr[1]);
				arr[1] = arr[lastIdx];
				arr[lastIdx--] = 0;
				
				int cur = 1;
				
				while(true) {
					int child = cur*2;
					if (child+1 <= lastIdx && arr[child] < arr[child+1]) child++;
					if (child > lastIdx || arr[child] < arr[cur]) break;
					swap(cur,child);
					cur = child;
				}
			}
		}
	}
	
	private static void swap(int cur, int i) {
		int tmp = arr[i];
		arr[i] = arr[cur];
		arr[cur] = tmp;
	}
}
