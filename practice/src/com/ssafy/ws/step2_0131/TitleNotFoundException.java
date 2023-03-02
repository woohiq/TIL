package com.ssafy.ws.step2_0131;

public class TitleNotFoundException extends Exception {
	
	// 기본 필드 변수 선언
	private String title;
	
	// getTitle 메서드 선언
	public String getTitle() {return title;}
	
	// 생성자 선언
	public TitleNotFoundException(String title) {
		this.title = title;
	}
}
