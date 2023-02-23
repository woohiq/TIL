package test01;

import java.util.Collections;
import java.util.PriorityQueue;

public class Test2 {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.offer(100);
		pq.offer(2);
		pq.offer(31);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());

		pq = new PriorityQueue<>(Collections.reverseOrder());
		// 우선ㅅ누위를 뒤집으려면
		// 생성자에 comparator
		
		pq.offer(100);
		pq.offer(2);
		pq.offer(31);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}
