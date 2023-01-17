package com.ssafy.ws.step2;
import java.io.*;
public class ArrayTest{
	public static void main(String[] args) throws IOException {
		// 배열 선언과 초기화를 한번에
		int[] iArr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		// 내용 출력
		for (int i = 0; i<iArr.length; i++) System.out.print(iArr[i]);
		
		// 입력 int 읽기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number_of_element = Integer.parseInt(br.readLine());
		
		// int만큼의 string개수를 저장할 수 있는 string array선언
		String[] sArr = new String[number_of_element];
		
		// 입력 받아 저장
		for (int i = 0; i<number_of_element;i++) {
			sArr[i] = br.readLine();
		}
		// 출력
		for (int i = 0; i<number_of_element;i++) {
			System.out.println(sArr[i]);
		}
	}
}
