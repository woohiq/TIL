package Test04;

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
	
	public int add(int a, int b) {
		return a+b;
	}
	// 메서드의 종류
	// 블록의 끝
	// return(void도 return가능)
	public void study(String subject) {
		double probability = Math.random();
		System.out.println(subject+"를 공부합니다");
		System.out.println("알고리즘 문제도 풉니다");
		if (probability < 0.9999)
			return;
		System.out.println("게임을 하네");
		System.out.println("롤 영상 보는중");
	}
	public void eat() {
		System.out.println("식사를 합니다");
	}
	public void eat(String dish) {
		System.out.println(dish+"를 먹습니다");
	}
	public void eat(String dish, int n) {
		System.out.println(dish+"를 "+n+"번 먹습니다");
	}
	public double add(double a, double b) {
		return a+b;
	}
}
