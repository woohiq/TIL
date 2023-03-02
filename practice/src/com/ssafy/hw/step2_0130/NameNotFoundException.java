package com.ssafy.hw.step2_0130;

public class NameNotFoundException extends Exception{
	// 필드 변수 선언
	private String name;
	// 생성자
	public NameNotFoundException(String name) {
		this.name = name;
	}
	// private변수에 접근할 메서드
	public String getName() {return name;}
}
