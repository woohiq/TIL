package test07_singleton;

public class PersonTest {
	public static void main(String[] args) {
		// 싱글턴 객체추가 생성 불가 
		//Person p1 = new Person();
		Person p1 = Person.getInstance();
//		p1.setAge(300);
//		p1.setAge(-10);
//		p1.setName("하하");
		System.out.println(p1.getAge());
		System.out.println(p1.getName());
		
		Person p2 = Person.getInstance();
		System.out.println(p1.getAge());
		System.out.println(p1.getName());
		
	}
}
