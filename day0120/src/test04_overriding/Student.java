package test04_overriding;

// 상속은 extend 키워드 사용
public class Student extends Person{

	String major;
	
	public Student(String name, int age, String major) {
		super(name,age); // 부모클래스의 생성자를 호출
		this.major = major;
	}
	
	//어노테이션을 붙이는 것을 권장
	//붙이지 않아도 되긴 함
	@Override
	public void eat() {
		System.out.println("지식을 먹는다");
	}
	public void study() {
		System.out.println("공부를 한다");
	}
}
