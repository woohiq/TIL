package Test01;
//모든클래스는 특정 패키지에 속해 있음

// class 키워드
public class Person {
	// 속성, 데이터, 필드, 변수
	String name;
	int age;
	
	//생성자
	//클래스명과 같음
	// 반화형을 지정하지 않음, 메서드와 다름
	public Person() {
		
	}
	
	// 메서드
	public void eat() {
		System.out.println(name+"이(가) 식사를 합니다");
	}
}
