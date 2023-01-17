package com.ssafy.ws.step2;
import java.io.*;
import java.util.StringTokenizer;
public class EmergencyExit {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 고도과 속도의 갯수 N입력받기
		int N = Integer.parseInt(br.readLine()); 
		
		// 고도, 속도를 저장할 배열 선언
		int[] altitude = new int[N];
		int[] speed = new int[N];
		
		// 속도를 입력받음
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<N; i++) speed[i] = Integer.parseInt(st.nextToken());
		
		// 고도를 입력받음
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i<N; i++) altitude[i] = Integer.parseInt(st2.nextToken());
		
		// 탈출 할 때의 순간을 리턴하는 함수 호출 후 결과값 출력
		System.out.println(isEscape(N, altitude, speed)); 
	}
	
	// 탈출 감지 함수 (인자 n:시점의 개수  alti:고도정보가 있는 배열  spd:속도정보가 있는 배열 )
	public static int isEscape(int n, int[] alti, int[] spd) {
		
		// 2분간 , 3분간, 4분간 고도와 상태를 감지하기 위해 i = 2,3,4
		for (int i = 2; i<= 4 && (n-i)>=1 ; i++) {
			// j는 인덱스 번호, 따라서 j 는 최대 n
			// i의 감지 시간에 따라 인덱스 최소값 설정
			// i분간 감지 이면 속도의 구간 평균을 위해 i분전의 속도에 접근해야 하므로 j는 최소 i
			// 예를들어, 4분간 감지 (i=4) 이면 속도의 구간 평균을 위해 4분 전의 속도에 접근해야하므로 j는 최소 4
			for (int j = i; j<n; j++) {
				// 고도 체크, i분간 고도가 i*1000미터 만큼 하강 (1번조건)
				if (alti[j-i]-alti[j] >= i*1000) { // 1번조건 만족시 2번조건 체크
					
					int spdavg = 0;
					// 속도의 구간합 : (j-1)+(j-2)+...+(j-i)지점의 속도 합
					// k = 1,2,...i로 두어서 구간합을 구함
					for (int k = 1; k<=i; k++) {
						spdavg += spd[j-k];
					}
					// (구간합)/(구간개수) = (구간평균)
					spdavg /= i;
					// 구간평균속도 체크, (2번조건)
					if (spdavg >= 1300-100*i) return j+1; // index가 j이면 탈출시점은 j+1점이므로 j+1리턴
				}
			}
		}
		return -1; // 모든 조건을 확인 해 보아도 탈출하지 않으면 -1 리턴
	}
}
