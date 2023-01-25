package com.ssafy.hw.step2;

public class UserTest {
	public static void main(String[] args) {
		// 기본 생성자를 통한 객체 생성
		User user1 = new User();
		user1.id = "user1";
		user1.password = "user1";
		user1.name = "김싸피";
		user1.email = "ssafy1@ssafy.com";
		user1.age = 27;
		
		// 인자를 입력받는 생성자를 통한 객체 생성
		User user2 = new User("ssafy", "ssafy", "박싸피", "ssafy@ssafy.com", 28);
		
		// 결과 출력
		System.out.println(user1.name); // user = user1
		System.out.println(user1.age); // age = 27
		System.out.println(user2.name); // user
		System.out.println(user2.age); // age = 28
	}
}
