package test04_protected_2;

import test04_protected.Person;

public class Student extends Person{
	
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.age = 1;
		// 상속을 받았으므로 다른 패키지에 있더라도 접근 가능
	}
}
