package com.ssafy.ws.step2;
import java.io.*;
import java.util.StringTokenizer;
public class SwitchOnOff {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N = 스위치 개수
		// M = 입력 개수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// N 개 element를 받을 수 있는 int array
		int switchs[] = new int[N];
		// 켤 스위치 번호 입력받기
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i<M; i++) {
			// 해당 숫자 배수 번호의 스위치를 조작하기위한 정수 입력받기
			int TurnOn = Integer.parseInt(st2.nextToken());
			// 스위치 조작. 절댓값을 이용해 0->1, 1->0
			switchs[TurnOn-1] = Math.abs(switchs[TurnOn-1]-1); // (-1)해주는 이유는 index는 switch numbering보다 1 작으므로
			
			// 정수의 배수 스위치도 조작 ( index가 넘어가지 않도록 배수j는 정수와 곱해도 스위치 개수를 넘지 않게 설정 )
			for (int j = 2; j<=N/TurnOn; j++) {
				// 스위치 조작. 절댓값을 이용해 0->1, 1->0
				switchs[TurnOn*j-1] = Math.abs(switchs[TurnOn*j-1]-1); // (-1)해주는 이유는 index는 switch numbering보다 1 작으므로
			}
		}
		
		// 결과 출력
		for (int i = 0; i<N; i++) {
			System.out.printf("%d ",switchs[i]);
		}
	}
}
