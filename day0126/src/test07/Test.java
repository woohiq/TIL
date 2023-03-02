package test07;

public class Test {
	public static void main(String[] args) {
		GenericBox<String> stringbox = new GenericBox<String>();
		// 제네릭 클래스의 변수를 선언
		// 제네릭 클래스로 객체를 만듦
		// 선언과 객체 생성시 타입을 지정
		
		stringbox.setData("Hello Generic");
		System.out.println(stringbox.getData());
		stringbox.genericMethod(123);
		
		// new 다음 생성자를 호출 할 떄 <> 안의 타입은 생략해도 됨
		// 컴파일러가 문맥에서 유추할 수 있기 때문
		// <> : diamond
		GenericBox<Integer> intBox = new GenericBox<>();
		intBox.setData(124);
		System.out.println(intBox.getData());
		
		// Integer : 래퍼 클래스 Wrapper Class
		// 기본형으로 사용하는 int -> 값
		// 래퍼클래스를 이용하면 객체처럼 이용 가능
		int b = 123;
		Integer c = 234;
		
		// 래퍼 클래스
		// byte -> Byte
		// short -> Short
		// int -> Integer
		// long -> Long
		// float -> Float
		// double -> Double
		// char -> Character
		// boolean -> Boolean
		// void -> Void
		
		int i1 = new Integer(123); // 그냥 기본형 값
		Integer i2 = new Integer(123); // 객체러럼 사용할 수도 있음
		
		//static method
		// int num = Integer.parseInt("835098295"); <- 문자열을 정수로
		
	}
}
