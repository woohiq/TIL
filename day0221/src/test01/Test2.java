package test01;

public class Test2 {
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	
	public static int factorial(int n) {
		if (n == 0) return 1;
		else {
			return factorial(n-1) * n;
		}
	}
}
