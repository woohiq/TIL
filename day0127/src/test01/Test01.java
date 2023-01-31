package test01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test01 {
	public static void main(String[] args) {
		// List
		// 순서 o
		// 중복 가능
		//List<String> names = new ArrayList<>();
		//List<String> names = new LinkedList<>();
		List<String> names = new Vector<>();
		
		// 원소 추가
		names.add("안중근");
		names.add("이봉창");
		names.add("이순신");
		names.add(0, "이순신"); // 0번 index에넣기
		names.set(2, "세종대왕");
		System.out.println(names);
		
		System.out.println(names.isEmpty());
		
		System.out.println(names.size());

		for (String name : names) System.out.println(name);

		Iterator<String> e = names.iterator();
		while(e.hasNext()) System.out.println(e.next());
		
		names.remove(2);
		System.out.println(names);
		
		names.remove("이순신");
		System.out.println(names);
		
		names.clear();
		
		names.add("홍승길");
		names.add("홍승길");
		names.add("홍승길");
		names.add("정민우");
		for (int i = 0; i<names.size(); i++) {
			System.out.println(names.get(i));
		}
		
//		for (int i = 0; i<names.size(); i++) {
//			if (names.get(i).equals("홍승길")) {
//				names.remove(i);
//			}
//		}
		for (int i = names.size()-1; i>=0; i--) {
			if (names.get(i).equals("홍승길")) {
				names.remove(i);
			}
		}
		System.out.println("-");
		System.out.println(names);
	}
}
