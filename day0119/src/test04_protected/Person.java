package test04_protected;

public class Person {
	protected String name;
	protected int age;
	
	public static void main(String[] args) {
		Person p1 = new Person();
		// 접근 가능
		p1.name = "한상빈";
	}
}
