package com.ssafy.ws;

public class DigitTest1 {
	public static void main(String[] args) {
		int num = 1;
		for (int i = 0; i<5; i++ ) { 
			for (int j = 0; j<i; j++) System.out.print("　  "); 
			for (int j = 0; j<(5-i); j++) { 
				System.out.printf("%2d ", num);
				num+=1;
			}
			System.out.print("\n");
		}
	}
}
