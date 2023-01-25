package com.ssafy.ws.step1;

public class CarTest {
	public static void main(String[] args) {
		Car car1 = new Car();

		// car1의 필드값을 작성해보자.
		// 자동차 등록번호
		car1.VIN = "TESTNUMBER01234567890";
		// 자동차 모델이름
		car1.modelName = "벤츠S클래스";
		// 자동차 색상
		car1.color = "Black";
		// 자동차 주행거리
		car1.mileage = 100;
		
		Car car2 = new Car("KNHXX00XXXX000000", "K5", "White", 35000);
		// 전체 결과 출력
		System.out.println("자동차 등록번호 : " + car1.VIN);
		System.out.println("자동차 모델이름 : " + car1.modelName);
		System.out.println("자동차 색상 : " + car1.color);
		System.out.println("자동차 주행거리 : " + car1.mileage);
		System.out.println("-------------------------------");
		System.out.println("자동차 등록번호 : " + car2.VIN);
		System.out.println("자동차 모델이름 : " + car2.modelName);
		System.out.println("자동차 색상 : " + car2.color);
		System.out.println("자동차 주행거리 : " + car2.mileage);
	}
}
