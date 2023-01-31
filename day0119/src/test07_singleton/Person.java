package test07_singleton;

public class Person {
	
	//싱글턴으로 바꾸기
	// 1. private로 자기자신 생성
	// static : 객체를 생성하지않고, 클래스 이름으로 접근하기 위함
	private static Person instance = new Person();
	
	// 생성자를 private로 막기
	private Person(){
		this.name = "유일한 사람";
		this.age = 123123;
	}
	
	// 유일한 객체에 접근할 수 있는 통로 만들기
	public static Person getInstance() {
		return instance;
	}
	
	
	private String name;
	private int age;
	private boolean hungry;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		
		return age;
	}
	public void setAge(int age) {
		if (age<0) {System.out.println("나이가 음수일 수 없습니다"); return;}
		if (age>200) {System.out.println("그렇게 오래 살 수 없다"); return;}
		this.age = age;
	}
	public boolean isHungry() {
		return hungry;
	}
	public void setHungry(boolean hungry) {
		this.hungry = hungry;
	}

	// 위 멤버변수에 접근할수 있는 통로를
	//public한 메서드로 만듦
	// 값을 변경 -> 설정자 setter : set+멤버이름
	// 값을 조회 -> 접근가 getter : get+멤버이름 boolean이면 is+멤버이름
	
	
}

