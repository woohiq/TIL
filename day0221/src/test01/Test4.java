package test01;

public class Test4 {
	public static void main(String[] args) {
		System.out.println(mfibo(90));
		// overflow로 인해 두자리수 후반부에서 한계
		// 시간은 문제없음!
	}
	
	static long[] memo = new long[200];
	
	// 스태틱 블록
	// 클래스가 로딩될 때 클래스 변수가 준비되고 난 후 자동으로 실행
	// 한 클래스 안에 여러 개의 스태틱 블록을 넣을 수 있다
	// 주로 클래스 변수 ( static 변수 ) 를 초기화 할 떄 사용
	static {
		memo[0] = 0;
		memo[1] = 1;
	}
	
	public static int fibo(int n) {
		if (n == 0 || n == 1) return n;
		else {
			return fibo(n-1) + fibo(n-2);
		}
	}
	
	public static long mfibo(int n) {
		if (n == 0 || n ==1) return memo[n];
		else if (memo[n] > 0) {
			return memo[n];
		} else {
			return memo[n] = mfibo(n-1)+mfibo(n-2);
		}
	}
}
