package com.ssafy.ws;
import java.io.*;
public class GameTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.\n\n1.5판 3승\n2. 3판 2승\n3. 1판 1승\n\n번호를 입력하세요");
		
		int N = Integer.parseInt(br.readLine());
		int wins = 0;
		int loses = 0;
		
		int total_game_number; // 최대 게임 횟수
		
		// 입력에 따른 전체 게임 횟수 설정
		if (N == 1) {total_game_number = 5;} // 1 -> 5판  
		else if (N == 2) {total_game_number = 3;} // 2-> 3판
		else {total_game_number = 1;} // 3-> 단판
		
		int winlose = total_game_number/2+1; // 5판 -> 3선승 , 3판 -> 2선승...
		
		while(total_game_number>0) {
			System.out.print("가위바위보 중 하나 입력:");
			String RSP = br.readLine(); // 가위 바위 보를 문자로 입력받음
			
			int rsp;
			
			if (RSP.equals("가위")) rsp= 1; // 가위 바위 보를 숫자로 변경
			else if (RSP.equals("바위")) rsp= 2;
			else rsp= 3;
			
			int computer_rsp = (int)(Math.random()*3)+1; // 컴퓨터 가위 바위 보
			
			// 한 판 승패판정
			if (rsp%3 == computer_rsp%3) System.out.println("비겼습니다!!!");
			else if ((rsp +1)%3 == computer_rsp%3){System.out.println("졌습니다!!!");loses++;}
			else {System.out.println("이겼습니다!!!"); wins++;}
			
			// 전체 승패 판정
			if (wins==winlose) {System.out.println("###사용자 승!!!"); break;}
			else if (loses==winlose) {System.out.println("###컴퓨터 승!!!"); break;}
			
			// 게임 잔여횟수 1회 감소
			total_game_number--;
			}
	}
}
