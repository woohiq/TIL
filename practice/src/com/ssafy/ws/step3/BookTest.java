package com.ssafy.ws.step3;

public class BookTest {
	public static void main(String[] args) {
		
		// Book type의 원소를 담을 수 있는 shelf라는 이름의 배열 선언
		Book[] shelf = new Book[2];
		
		// Book1은 기본 생성자로 생성
		Book book1 = new Book();
		book1.isbn = "21424";
		book1.title = "Java Pro";
		book1.author = "김하나";
		book1.publisher = "jaen.kr";
		book1.price = 15000;
		book1.desc = "Java 기본 문법";
		
		// Book2는 인자를 받는 생성자로 생성
		Book book2 = new Book("35355", "분석 설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		
		// 원소를 배열에 넣기
		shelf[0] = book1;
		shelf[1] = book2;
		
		// 출력
		System.out.println("**********************도서목록**********************");
		for (int i = 0; i<2; i++) {
			System.out.println(Book.toString(shelf[i]));
		}
		
		// Book.java에 있는 toString2()함수도 같은 출력을 보냄
//		System.out.println("**********************도서목록**********************");
//		for (int i = 0; i<2; i++) {
//			System.out.println(shelf[i].toString2());
//		}
	}
}
