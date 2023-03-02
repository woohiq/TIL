package com.ssafy.ws;
import java.io.*;
public class AppleTree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N*N 행렬을 만들기 위한 N입력받기
		int N = Integer.parseInt(br.readLine());
		// 이중배열 선언, 이 때 외곽에 padding을 1씩 줌 (계산을 쉽게 하기 위해서)
		int[][] plane = new int[N+2][N+2];
		
		// 이중루프를 돌면서 index 1~N까지에 이중배열에 값을 채움
		// 이 때, index 0과 (N+1)은 0으로 채워져있음
		for (int i = 1; i<=N; i++) {
			String oneline = br.readLine();
			for (int j = 1; j<=N; j++) {
				// charAt으로 char값을 받아오면 unicode값으로 실제 int값과 다르기 때문에 '0'만큼의 unicode값을 빼 줌
				plane[i][j] = (int)(oneline.charAt(j-1)-'0');
			}
		}
		
		// 상하좌우 합의 최댓값 찾기
		int maximum = 0;
		for (int i = 1; i<=N; i++) {
			for (int j = 1; j<=N; j++) {
				// 배열의 이중루프를 돌면서 상하좌우 값 계산
				// index 0과 (N+1)은 0으로 채워져 있기 때문에
				// index 1~N 에서 플러스마이너스 1을 해도 오류가 일어나지 않음
				int nutri = plane[i][j] + plane[i+1][j] + plane[i-1][j] + plane[i][j+1] + plane[i][j-1];
				if (nutri>maximum) maximum = nutri;
			}
		}
		// 최대값 출력
		System.out.println(maximum);
	}
}
