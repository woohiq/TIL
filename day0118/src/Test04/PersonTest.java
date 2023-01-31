package Test04;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		int sum = p1.add(4, 5);
		double sum2 = p1.add(4.5, 5.3);
		System.out.println(sum);
		System.out.println(sum2);
		p1.study("자1바");
		p1.eat();
		p1.eat("햄버거");
		p1.eat("버거",7);
	}
}
