package com.ssafy.ws.step4;

public class RestaurantTest {
	public static void main(String[] args) {
		
		// 레스토랑 타입을 인자로 받는 맛집리스트 배열 선언
		Restaurant[] Matjiplist = new Restaurant[2];
		
		// 기본 생성자를 이용해 객체 생성
		Restaurant SeoulMatjip = new Restaurant();
		SeoulMatjip.resId = 101;
		SeoulMatjip.name = "을밀대";
		SeoulMatjip.address = "서울";
		SeoulMatjip.signatureMenu = "냉면";
		SeoulMatjip.rate = 4;
		
		// 인자를 이용한 생성자를 이용해 객체 생성
		Restaurant DaeguMatjip = new Restaurant(401, "도마29", "대구", "연어초밥", 3);
		
		// 배열에 값을 넣기 
		Matjiplist[0] = SeoulMatjip;
		Matjiplist[1] = DaeguMatjip;
		
		
		// 리뷰 타입을 인자로 받는 리뷰컬렉션 배열 선언
		Review[] ReviewCollection = new Review[2];
		
		// 기본 생성자를 이용해 객체 생성
		Review Kimssapy = new Review();
		Kimssapy.reviewId = 1;
		Kimssapy.resId = 101;
		Kimssapy.writer = "김싸피";
		Kimssapy.content = "너무 맛있네요.";
		
		// 인자를 이용한 생성자를 이용해 객체 생성
		Review Nassapy = new Review(1, 101, "김싸피", "연어초밥은 여기가 최고!");
		
		// 배열에 값을 넣기 
		ReviewCollection[0] = Kimssapy;
		ReviewCollection[1] = Nassapy;
		
		// 배열안의 값들 출력, 레스토랑 정보와 리뷰 정보가 출력
		System.out.println("***********************맛집목록***********************");
		for (int i = 0; i<2; i++) {
			System.out.println(Matjiplist[i].toString());
		}
		System.out.println("***********************리뷰목록***********************");
		for (int i = 0; i<2; i++) {
			System.out.println(ReviewCollection[i].toString());
		}
	}
}
