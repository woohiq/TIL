package test06_getter_setter;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setAge(300);
		p1.setAge(-10);
		p1.setName("하하");
		System.out.println(p1.getAge());
		System.out.println(p1.getName());
		
	}
}
