package test01;

public class Test1 {
	public static void main(String[] args) {
		// �ݺ��� <=> ���
		
		for (int i = 0; i<5; i++) {
			System.out.println(i);
		}
		
		// ����Լ��� ������� 
		// n�� ���� ���� , ��ü���� fn
		// �κй��� fn-1 fn-2
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
