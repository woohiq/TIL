package test01_interface;

// 클래스는 인터페이스를 구현
// 인터페이스는 클래스에의해 구현됨
// 클래스가 인터페이스를 구현 할 때는 implements 키워드 사용
public class MyClass implements MyInterface{
	// 클래스는 구현하는 인터페이스이 모든 메서드를 override 해야함
	@Override
	public void method1() {
		System.out.println("method 1");
		
	}

	@Override
	public void method2() {
		System.out.println("method 2");
		
	}
	
	
}
