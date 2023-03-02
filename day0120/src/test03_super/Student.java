package test03_super;

// 상속은 extend 키워드 사용
public class Student extends Person{

	String major;
	
	public Student(String name, int age, String major) {
		super(name,age); // 부모클래스의 생성자를 호출
		this.major = major;
	}

	public void study() {
		System.out.println("공부를 한다");
	}
}
