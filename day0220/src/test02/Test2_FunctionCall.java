package test02;

public class Test2_FunctionCall {
	public static void main(String[] args) {
		System.out.println("���� �۾� ����");
		func1();
		System.out.println("���� �۾� ��");
	}
	public static void func1() {
		System.out.println("�Լ� 1 �۾� ����");
		func2();
		System.out.println("�Լ� 1 �۾� ��");
	}
	public static void func2() {
		System.out.println("�Լ� 2 �۾� ����");
		System.out.println("�Լ� 2 �۾� ��");
	}
}
