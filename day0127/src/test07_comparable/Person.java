package test07_comparable;
// Collections.sort를 쓸려면 comparable 인터페이스 구현
public class Person implements Comparable<Person>{
	private String name;
	private String id;
	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person other = (Person)obj;
			return this.id.equals(other.id);
		} else return false;
	}
	@Override
	public int compareTo(Person o) {
//		return this.name.compareTo(o.name);
		return Integer.parseInt(this.id)-Integer.parseInt(o.id);
	}
	
	
}
