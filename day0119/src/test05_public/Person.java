package test05_public;

public class Person {
	public String name;
	public int age;
	
	public static void main(String[] args) {
		Person p1 = new Person();
		// 접근 가능
		p1.name = "한상빈";
	}
}
