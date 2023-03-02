package test01;

public class Test4 {
	public static void main(String[] args) {
		System.out.println(mfibo(90));
		// overflow�� ���� ���ڸ��� �Ĺݺο��� �Ѱ�
		// �ð��� ��������!
	}
	
	static long[] memo = new long[200];
	
	// ����ƽ ���
	// Ŭ������ �ε��� �� Ŭ���� ������ �غ�ǰ� �� �� �ڵ����� ����
	// �� Ŭ���� �ȿ� ���� ���� ����ƽ ����� ���� �� �ִ�
	// �ַ� Ŭ���� ���� ( static ���� ) �� �ʱ�ȭ �� �� ���
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
