package test02_private;

public class Person {
	private String name;
	private int age;
	
	public static void main(String[] args) {
		Person p1 = new Person();
		// 접근 가능
		p1.name = "한상빈";
	}
}
