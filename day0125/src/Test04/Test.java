package Test04;


public class Test {
	public static void main(String[] args) {
		// 자식 클래스에서 추상 클래스에 없는 메서드를 추가
		Animal a = new Cat();
		
		Animal a2 = new Dog();
		
		Animal a3 = new Person();
		
		// 부모 클래스 타입의 변수이지만
		// 메서드의 호출은 실제 생성된 객체가 갖고 있는 메서드
		((Cat)a).eat(); 
		// 왜안될까  animal은 해당 메서드가 없어서
		// 부모클래스에 추상메서드 혹은 일반메서드를 저으이해놔야
		// 부모클래스 타입으로 참조했으 때 메서드 사용 가능
		
		// 아니면 instanceof 를 이용해서 형변환
		// instanceof 연산자
		// 객체가 해당 클래스로 만든 객체이거나 
		// 객체가 해당 클래스의 조상클래스로 만든 객체인 경우 True
		// 자식클래스로 만들거나 전혀 상관없으면 false
		Cat c = (Cat) a;
		c.eat();
		System.out.println(a instanceof Animal);
		System.out.println(a instanceof Cat);
		System.out.println(a instanceof Dog);
		a2.speak();
		a3.speak();
		
	}
}
