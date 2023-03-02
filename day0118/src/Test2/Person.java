package Test2;

public class Person {
	// static 키워드 : 클래스 변수 -> 이 클래스로 시작되는 모든 인스턴스 공유
	static String species = "호모 사피엔스 사피엔스";
	
	// static 없으면 인스턴스변수
	String name;
	int age;
	
	// 생성자 x
	// 만약 설계도에 생성자가 하나도 없다면
	// JVM이 기본 생성자를 추가해줌
	// Person() {};
	
	public void eat() {
		// 지역변수
		String dish = "짜장면";
	}
}
