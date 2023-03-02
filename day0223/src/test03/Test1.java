package test03;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Test1 {
	public static void main(String[] args) {
//		PriorityQueue<Person> pq = new PriorityQueue<>(new NameComparator());
		
		//무명 클래스 : 이름이 없음, 단 한번만 객체 생성
//		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.age - o2.age;
//			}
//		});
		
		// 람다 표현식
		// 함수를 간결하게, 메서드의 길이가 짧은 경우 사용
		// 람다식은 함수형 프로그래밍을 자바에 도입한 
		// 문법 : (파라미터) -> { body } 파라미터가 단일 매개변수일 때 ()생략가능
		// body가 단일 문장일 떄 {} 생략 가능
		
		PriorityQueue<Person> pq =  new PriorityQueue<>((o1,o2) -> {
			return o1.age - o2.age;
		});
		
		pq.offer(new Person("김민식", 22));
		
		pq.offer(new Person("유태영", 55));
		
		pq.offer(new Person("차지은", 17));
		
		pq.offer(new Person("신산하", 23));
		
		pq.offer(new Person("김두현", 7));
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}
