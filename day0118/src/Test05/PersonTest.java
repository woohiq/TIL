package Test05;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person("한", 27);
		Person p2 = new Person();
		
		System.out.println(p1.name);
		System.out.println(p1.age);
		
		System.out.println(p2.name);
		System.out.println(p2.age);
		p1.study("자1바");
		p1.eat();
		p1.eat("햄버거");
		p1.eat("버거",7);
	}
}
