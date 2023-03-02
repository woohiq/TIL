package test06_object;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Student st = new Student("박사홍", 28, "자바");
		Person st2 = new Student("박사홍", 28, "자바");
		
		System.out.println(st == st2);
		System.out.println(st.equals(st2));
		
		Object o = new Object();
		o.equals(st);
		
		st.eat();
		st.study();
		
		//Person st2 = new Student("양멍균", 29, "자바");
		st2.eat(); // 지식을 먹는다가나옴
		
		System.out.println(st.toString()); 
		
		String a = "214284";
		a.equals("29482");
		
		Set<Student> set = new HashSet<>();
		set.add(st);
		//set.add(st2);
		System.out.println(set.size());
		// set에서는 동일성을 판단하기 위해서 equals도 쓰지만 hashcode 도 사용
	}
	
	
}
