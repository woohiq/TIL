package com.ssafy.ws;
import java.io.*;
import java.util.StringTokenizer;
public class AirplaneAccident {
	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input_number = Integer.parseInt(br.readLine());
		
		// 해당 정수만큼의 사상자수를 저장할 수 있는 배열
		int[] AirplaneCasualty = new int[input_number];
		
		// 최대사상자수, 최소사상자수를 찾기위해 max,min 초기화
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		// 사상자 수를 입력받아 배열에 저장
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i< input_number; i++) {
			int casualty = Integer.parseInt(st.nextToken());
			AirplaneCasualty[i] = casualty;
			
			// 사상자 수 최대, 최소 구하기
			if (casualty > max) max=casualty;
			else if (casualty < min) min=casualty;
		}
		
		// 만약 최소 사상자 수 == 마지막 비행기 사고 사상자 수 -> -1을 출력
		if (AirplaneCasualty[input_number-1] == min) System.out.println("-1");
		
		// 그렇지 않으면 ( 최대 사상자 수 - 최근 마지막 사고보다 인원 적은 사상자 수 )
		else {
			for (int j = input_number-1; j>=0; j--) {
				if (AirplaneCasualty[j] < AirplaneCasualty[input_number-1]) {
					System.out.println(max - AirplaneCasualty[j]);
					break;
				}
			}
		}
	}
}
