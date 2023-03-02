package test01;

public class Test1 {
	public static void main(String[] args) {
		// 반복문 <=> 재귀
		
		for (int i = 0; i<5; i++) {
			System.out.println(i);
		}
		
		// 재귀함수로 만드려면 
		// n에 대한 문제 , 전체문제 fn
		// 부분문제 fn-1 fn-2
		rf(0, 5);
	}
	
	public static void rf(int idx, int end) {
		if (idx == end) return;
		else {
			System.out.println(idx);
			rf(idx+1, end);
		}
	}
}
