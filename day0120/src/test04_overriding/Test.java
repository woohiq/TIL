package test04_overriding;

public class Test {
	public static void main(String[] args) {
		Student st = new Student("박사홍", 28, "자바");
		
		st.eat();
		st.study();
		
		Person st2 = new Student("양멍균", 29, "자바");
		st2.eat(); // 지식을 먹는다가나옴
	}
	
	
}
