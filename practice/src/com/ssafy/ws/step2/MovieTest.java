package com.ssafy.ws.step2;

public class MovieTest {
	public static void main(String[] args) {
		// 아바타 1 = 인자 입력 없는 생성자로 생성
		Movie avatar1 = new Movie();
		// 아바타 2 = 인자 입력 있는 생성자로 생성
		Movie avatar2 = new Movie(0001, "아바타2", "제임스 카메론", "SF액션", 192);
		
		System.out.println("아바타1 아이디 : "+avatar1.id); // 아이디 = 0
		System.out.println("아바타1 제목 : "+avatar1.title); // 제목  = null
		
		System.out.println("아바타2 아이디 : "+avatar2.id); // 아이디 = 1
		System.out.println("아바타2 제목 : "+avatar2.title); // 제목 = 아바타2
		System.out.println("아바타2 감독 : "+avatar2.director); // 감독 = 제임스 카메론
		
		// 인스턴스 정보 수정
		avatar1.id = 0002;
		avatar1.title = "아바타1";
		
		System.out.println("아바타1 아이디 : "+avatar1.id); // 아이디 = 2
		System.out.println("아바타1 제목 : "+avatar1.title); // 제목 = 아바타1
		
		
	}
}
