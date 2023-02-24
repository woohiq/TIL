package test01;

import java.util.LinkedList;

public class Test1 {
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(1); // 맨 뒤
		list.addLast(2); // 맨 뒤
		list.addFirst(3); // 맨 앞
		list.add(2, 4); // 특정 인덱스
		 
		list.remove(); // 가장 앞 원소 제거
		list.remove(2); // 해당 인덱스 원소 제거
		list.removeLast(); // 맨 뒤 원소 제거
		
		list.offer(6); // 맨 뒤 추가
		list.push(7); // 맨 앞 추가
		list.pop(); // 맨 앞 빼기
		list.add(8);
		list.poll(); // 맨 앞 빼기
		System.out.println(list);
	}
}
