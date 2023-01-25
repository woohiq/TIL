package com.ssafy.ws;
import java.io.*;
import java.util.StringTokenizer;
public class YongGwangRo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 시작온도, 목표온도
		int StartTemp = Integer.parseInt(st.nextToken());
		int FinalTemp = Integer.parseInt(st.nextToken());
		
		// 저장된 온도 수
		int Channel = Integer.parseInt(br.readLine());
		
		// (임시)최솟값 = 온도 감소만으로 목표온도로 갈 수 있는 횟수
		int minimum = Math.abs(FinalTemp - StartTemp);
		
		// 만약 저장된 온도를 이용한 온도 설정이 더 빠르면, 그 값을 사용
		for (int i = 0; i<Channel; i++) {
			int SavedTemperature = Integer.parseInt(br.readLine());
			int TemperatureDifference = Math.abs(FinalTemp-SavedTemperature);
			// 시작 온도에서 목표 온도 차이보다 저장된 온도와 목표온도의 차이가 더 작다면, 그 값을 사용 
			// (대신 저장된 값으로 바꾸느라 1초 소모)
			if (TemperatureDifference < minimum) {minimum = TemperatureDifference; minimum++;}
		}
		
		//600초가 넘으면 -1출력, 600초가 넘지 않으면 최소값출력
		if (minimum > 600) System.out.println("-1");
		else System.out.println(minimum);
		
		
	}
}
