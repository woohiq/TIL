package test02;

public class Person implements Comparable<Person>{
	public String name;
	public int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
//	@Override
//	public int compareTo(Person o) {
//		return this.age-o.age;
//	}
	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
	
}
