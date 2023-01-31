package test08_polymorphism2;


public class Test {
	public static void main(String[] args) {
		Person[] people = new Person[3];
		people[0] = new Person("홍승길", 27);
		people[1] = new Person("정민우", 28);
		people[2] = new Student("오지혜", 20, "자바");
		
		for (Person p : people) {
			System.out.println(p.toString());
		}
		
		Person st = new Student("이승재", 25, "자바");
		Person p2 = new Person("감싸피", 28);
		//Student st2 = (Student)p2;
		// st2.study(); error
		
		Student p3 = (Student)st;
		p3.study();
		
		
	}
	
	
}
