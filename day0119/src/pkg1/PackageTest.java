package pkg1;

import pkg1.pkg2.pkg3.Person;
public class PackageTest {
	public static void main(String[] args) {
//		Person p1 = new Person();
//		System.out.println(p1.pkg);
		
		
		// 만약 서로다른 패키지의 이름이 같은 클래스를 두개이상쓰고싶다면
		// 생략 x
		// 패키지명.클래스명 -> 풀 패키지 이름
		pkg1.Person p1 =new pkg1.Person();
		pkg1.pkg2.Person p2 = new pkg1.pkg2.Person();
		Person p4 = new Person();
		
		System.out.println(p1.pkg);
		System.out.println(p2.pkg);
		System.out.println(p4.pkg);
		
		
	}
}
