package test01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
public class Test02 {
	public static void main(String[] args) {
		List<Object> al = new ArrayList<>();
		List<Object> ll = new LinkedList<Object>();
		List<Object> v = new Vector<Object>();
	
		test1("순차적-어레이리스트", al);
		test1("순차적-링크드리스트", ll);
		test1("순차적-벡터", v);
		test2("중간에-어레이리스트", al); // 하나씩 밀고 넣어야 하므로 linked가 젤빠름
		test2("중간에-링크드리스트", ll);
		test2("중간에-벡터", v);
		test3("조회-어레이리스트", al); // 조회
		test3("조회-링크드리스트", ll);
		test3("조회-벡터", v);
		
	}
	
	public static void test1(String testname, List<Object> list) {
		long start = System.nanoTime();
		for (int i = 0; i<50000; i++) {
			list.add(new String("Hello")); // 뒤에추가
		}
		long end = System.nanoTime();
		System.out.printf("%10s \t 소요시간 : %15d ns. \n", testname, end-start);
	}
	public static void test2(String testname, List<Object> list) {
		long start = System.nanoTime();
		for (int i = 0; i<50000; i++) {
			list.add(0, new String("Hello")); // 앞에추가
		}
		long end = System.nanoTime();
		System.out.printf("%10s \t 소요시간 : %15d ns. \n", testname, end-start);
	}
	public static void test3(String testname, List<Object> list) {
		long start = System.nanoTime();
		for (int i = 0; i<list.size(); i++) {
			list.get(i); // 앞에추가
		}
		long end = System.nanoTime();
		System.out.printf("%10s \t 소요시간 : %15d ns. \n", testname, end-start);
	}
}
