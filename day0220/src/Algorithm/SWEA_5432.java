package Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) {
		
		// ��ĳ�� ���� �� testCase �Է¹ް� �׸�ŭ �ݺ�
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		
		// ������ ���� Ȯ��
		for (int tc = 0; tc<testCase; tc++) {
			String str = sc.nextLine();
			Stack<Character> stack = new Stack<>();

			// ������ ǥ���� ���� answer
			int answer = 0;
			
			// �ϴ� �ϳ� �ְ� ����
			stack.push(str.charAt(0));
			
			/*
			 * �Է¿� ���� ������ ���� 3���� ���� ������
			 * 1.  () ���� üũ�ϰ�, ()��� ť�� ���̸�ŭ +
			 * 2.  ( �̸� ť�� �߰�
			 * 3.  )�̸� ť�� �ִ� �� �ϳ� ����, �׸��� 1��ŭ +
			 */
			for (int i = 1; i<str.length(); i++) {
				char currentChar = str.charAt(i);
				char lastChar = str.charAt(i-1);
				if (currentChar == ')' && lastChar == '(') {
					stack.pop();	
					answer += stack.size();
				} else if (currentChar == '(') {
					stack.push(currentChar);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
						answer++;
					}
				}
			}
			// ��� ���
			System.out.println("#"+(tc+1)+" "+answer);
		}
	}
}
