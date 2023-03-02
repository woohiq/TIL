package com.ssafy.ws.step4;

public class Review {
	int reviewId;
	int resId;
	String writer;
	String content;
	
	// 기본 생성자
	public Review(){}
	
	// 인자를 받는 생성자
	public Review(int reviewId, int resId, String writer, String content) {
		this.reviewId = reviewId; // this를 사용해서 인스턴스 멤버에 지역변수 대입
		this.resId = resId;
		this.writer = writer;
		this.content = content;
	}
	
	// this를 사용해서 정보를 String 타입으로 리턴하는 메소드
	public String toString() {
		return String.format("Review [reviewId=%d, resId=%3d, writer=%s, content=%s]", this.reviewId, this.resId, this.writer, this.content);		
	}
}
