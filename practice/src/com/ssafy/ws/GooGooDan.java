package com.ssafy.ws;
import java.util.Scanner;
public class GooGooDan {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
        	// 숫자 입력
        	System.out.print("숫자를 입력하세요 : ");
        	int n = sc.nextInt();
        	if (n==0) {sc.close();return;} // 0이면 return으로 main함수 종료
        	
	        StringBuffer sb = new StringBuffer();
	        
	        for (int i = 1; i<= 9; i++){ // 구구단 출력 ( n * i = ni )
	            sb.append(n).append(" * ").append(i).append(" = ").append(n*i).append("\n");
	        }
	        System.out.print(sb);
        }
        
    }
}
