package com.ssafy.ws.step4;

public class Restaurant {
	int resId;
	String name;
	String address;
	String signatureMenu;
	int rate;
	
	// 기본 생성자
	public Restaurant() {}
	
	// 인자를 받는 생성자
	public Restaurant(int resId, String name, String address, String signatureMenu, int rate) {
		this.resId = resId; // this를 사용해서 인스턴스 멤버에 지역변수 대입
		this.name = name;
		this.address = address;
		this.signatureMenu = signatureMenu;
		this.rate = rate;
	}
	
	// this를 사용해서 정보를 String 타입으로 리턴하는 메소드
	public String toString() {
		return String.format("Resturant [resID=%3d, name=%s, address=%s, signatureMent=%s, rate=%d]",this.resId, this.name, this.address, this.signatureMenu, this.rate);
	}
}
