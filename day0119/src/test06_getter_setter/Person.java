package test06_getter_setter;

public class Person {
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

