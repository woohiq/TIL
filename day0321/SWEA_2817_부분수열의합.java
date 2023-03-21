package day0321;

import java.util.Scanner;

public class SWEA_2817_부분수열의합 {
	static int N, K, ans;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc<=testCase; tc++) {
			
			// 입력 자연수 개수 N
			// 찾아야 하는 수 K
			N = sc.nextInt();
			K = sc.nextInt();
			
			// 입력을 받기
			numbers = new int[N];
			ans = 0;
			
			for (int i = 0; i<N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			// 재귀 출발
			select(0, 0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	public static void select(int index, int sum) {
		
		// 만약 합이 K라면 찾았다 ( 더 더해봐야 의미없음 )
		if (sum == K) {
			ans++;
			return;
			
			// 끝까지 찾았으면 못찾았다 ( 더 더할것이 없음 )
		} if (index == N) {
			return;
		}
		
		// 해당 인덱스를 선택하고, 서선택안한 경우를 재귀호출
		select(index+1, sum);
		select(index+1, sum+numbers[index]);
	}
}
