package test02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		//Set<String> set = new HashSet<>();
		Set<String> set = new TreeSet<>();
		// HashSet  해시테이블에 저장 , 성능에서 우수, 순서일정 x
		// Treeset red-black tree에 저장, 값에 따라 순서, 값을 순서대로 정렬할 필요있다면 고려
		
		set.add("홍승길");
		set.add("홍승길");
		set.add("정민우");
		set.add("이승재");
		System.out.println(set);
		System.out.println("홍승길".hashCode());
		System.out.println(new String("홍승길").hashCode()); // 같은 문자열이면 같은 해시코드
		// 따라서 이걸로 set에서 중복 체크하는거임 
		System.out.println("홍승길".equals("홍승길"));
		
		Iterator<String> e = set.iterator();
		while(e.hasNext()) {
			System.out.println(e.next());
		}
	}
}
