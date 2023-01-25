package com.ssafy.ws;

public class DigitTest2 {
	public static void main(String[] args) {
		int num = 1;
		for (int i = 0; i<5; i++ ) {
			
			// (5-Math.abs(4-2*i)+1) = 5, 3, 1, 3, 5 ...
			for (int k = 1; k<=(5-Math.abs(4-2*i))/2;k++) { 
				System.out.printf("%3s","");
			}
			
			for (int j = 0; j<=Math.abs(4-2*i); j++) {
				System.out.printf("%3d",num);
				num++;
			}
			System.out.println("");
		}
	}
	public static void main2(String[] args) {
		int cnt = 1; // 숫자출력
		int blank = 0; // 공백출력
		boolean isIncrease = true;
		int target = 5/2; //공백의 증가가 반전이 되는 point
		//while 활용해서 1~17 값을 올리면서 출력
		while(cnt <= 17) {
			//공백 출력
			for(int i = 0; i < blank; i++) System.out.printf("%3s","");
			//숫자 출력
			for (int j = 0; j < 5-2*blank; j++ ) System.out.printf("%3d",cnt++);
			
			if(isIncrease) blank++;
			else blank--;
			if (blank==target) isIncrease=false;
			
			System.out.println("");
		}
		
	}
	
}
