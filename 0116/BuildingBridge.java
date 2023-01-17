package com.ssafy.ws.step2;
import java.io.*;
public class BuildingBridge {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N*N 행렬을 만들기 위한 N입력받기
		int N = Integer.parseInt(br.readLine());
		int[][] plane = new int[N+2][N+2];
		
		
		for (int i = 1; i<=N; i++) {
			String oneline = br.readLine();
			for (int j = 1; j<=N; j++) {
				// charAt으로 char값을 받아오면 unicode값으로 실제 int값과 다르기 때문에 '0'만큼의 unicode값을 빼 줌
				plane[i][j] = (int)(oneline.charAt(j-1)-'0');
			}
		}
		int maximum = 0;
		// 다리 길이 최댓값
		for (int i = 1; i<=N; i++) {
			for (int j = 1; j<=N; j++) {
				if (plane[i][j] == 1) {
					for (int k = 1; (k+i)<=N; k++) {
						if (plane[i+k][j] == 1 && k>maximum) {maximum = k; break;}
						else if (plane[i+k][j] == 1) break;
					}
					for (int k = 1; (k+j)<=N; k++) {
						if (plane[i][j+k] == 1 && k>maximum) {maximum = k; break;}
						else if (plane[i][j+k] == 1) break;	
					}
				}
				//else continue;
			}
		}
		// 최대값 출력
		System.out.println(maximum);
	}
}
