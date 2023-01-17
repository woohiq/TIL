package com.ssafy.ws.step2;
import java.io.*;
public class ArrayTest2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정수 자료형을 가진 1차원 배열 선언과 출력, 10부터 19까지
		int[] iArr = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		
		// 한 칸씩 띄워서 출력
		System.out.println("-----원소 10개 출력-----");
		for (int i = 0; i<iArr.length; i++) System.out.printf("%d ",iArr[i]);
		System.out.println(""); // 줄바꿈
		
		// 짝수만 출력
		System.out.println("-----원소 10개 중 짝수만 출력-----");
		for (int i = 0; i<iArr.length; i++) {
			if (iArr[i]%2 == 0) System.out.printf("%d ",iArr[i]); // 짝수 -> 2로 나누어떨어짐
		}
		System.out.println(""); // 줄바꿈
		
		//바꿀위치와 수 입력받기
		System.out.print("-----바꿀 위치 입력 : ");
		int change_position = Integer.parseInt(br.readLine());
		System.out.print("-----수 입력 : ");
		int change_number = Integer.parseInt(br.readLine());
		
		// 배열 접근해서 원소 바꾸기
		iArr[change_position] = change_number;
		
		// 결과 출력
		System.out.println("-----원소 10개 출력-----");
		for (int i = 0; i<iArr.length; i++) System.out.printf("%d ",iArr[i]);
	
	}
}
