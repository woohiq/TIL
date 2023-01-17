package com.ssafy.ws;

public class DigitTest1 {

	public static void main(String[] args) {
		int num = 1;
		for (int i = 0; i<5; i++ ) { 
			for (int j = 0; j<i; j++) System.out.printf("%3s",""); 
			for (int j = 0; j<(5-i); j++) { 
				System.out.printf("%3d", num);
				num+=1;
			}
			System.out.print("\n");
		}
	}

}
//
//public class DigitTest1 {
//	public static void main(String[] args) {
//		int num = 1;
//		for (int i = 0; i<5; i++ ) { 
//			for (int j = 0; j<5; j++){
//				if (i>j) System.out.printf("%3s","");
//				else System.out.printf("%3d", num++); 
//			}
//			System.out.print("\n");
//		}
//	}
//}
