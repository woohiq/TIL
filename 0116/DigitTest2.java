package com.ssafy.ws;
public class DigitTest2 {
	public static void main(String[] args) {
		int num = 1;
		for (int i = 0; i<5; i++ ) {
			
			// (5-Math.abs(4-2*i)+1) = 5, 3, 1, 3, 5 ...
			for (int k = 1; k<(5-Math.abs(4-2*i)+1)/2;k++) { 
				System.out.print("   ");
			}
			
			for (int j = 0; j<Math.abs(4-2*i)+1; j++) {
				System.out.printf("%2d ",num);
				num++;
			}
			System.out.println("");
		}
	}
}
