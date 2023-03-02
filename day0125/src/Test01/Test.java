package Test01;

public class Test {
	public static void main(String[] args) {
		
		// 다형성
		Animal a = new Cat();
		
		Animal a2 = new Dog();
		
		Animal a3 = new Person();
		
		// 부모 클래스 타입의 변수이지만
		// 메서드의 호출은 실제 생성된 객체가 갖고 있는 메서드
		a.speak();
		a2.speak();
		a3.speak();
		
		// 추상 클래스 사용 이유
		// 객체 생성 막기
		// 자식 클래스 메서드 재정의 강제
		// 다형성
		// 상속 이용
	}
}
