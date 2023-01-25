package com.ssafy.ws.step3;

import java.util.Scanner;

public class Checkmate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수 입력받음
		int test_case = sc.nextInt();
		for (int i = 0; i<test_case; i++) {
			// 게임판의 크기 N과 킹의 xy좌표 퀸의 xy좌표를 입력받음
			int N = sc.nextInt();
			int whiteKingX = sc.nextInt();
			int whiteKingY = sc.nextInt();
			int blackQueenX = sc.nextInt();
			int blackQueenY = sc.nextInt();
			
			// 게임판 선언, 알아보기 쉽게 하기 위해 N+1크기의 이중 배열로 선언하고
			// index 0은 사용하지 않음 (실제 인덱스 숫자 = 킹의 xy좌표 와 같게 하기 우해)
			int[][] chessBoard = new int[N+1][N+1];
			
			// 킹과 x좌표가 같거나
			// 킹과 y좌표가 같거나
			// 킹과 x좌표와 y좌표의 차이가 같은 지점은 퀸이 있으면 위험한 지역이므로
			// 해당 지역 좌표에 1의 값을 저장
			for (int j = 1; j<N+1; j++) {
				chessBoard[whiteKingX][j] = 1;
			}
			for (int j = 1; j<N+1; j++) {
				chessBoard[j][whiteKingY] = 1;
			}
			for (int j = -N; j<=N; j++) {
				if (1<=j+whiteKingX && j+whiteKingX<=N && 1<=j+whiteKingY && j+whiteKingY<=N)chessBoard[j+whiteKingX][j+whiteKingY] = 1;
				if (1<=j+whiteKingX && j+whiteKingX<=N && 1<=-j+whiteKingY && -j+whiteKingY<=N)chessBoard[j+whiteKingX][-j+whiteKingY] = 1;
			}
			// 퀸의 위치가 좌표값이 1인 지역이면, 퀸이 킹을 공격할 수 있으므로 1출력, 그렇지 않으면 0출력
			if (chessBoard[blackQueenX][blackQueenY] == 1) System.out.printf("#%d 1\n",i+1);
			else System.out.printf("#%d 0\n",i+1);
		}
	}
}
