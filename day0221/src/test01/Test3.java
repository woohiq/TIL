package test01;

public class Test3 {
	public static void main(String[] args) {
		System.out.println(fibo(45));
		// 45가 한자리수 초 의 한계
	}
	
	public static int fibo(int n) {
		if (n == 0 || n == 1) return n;
		else {
			return fibo(n-1) + fibo(n-2);
		}
	}
}
