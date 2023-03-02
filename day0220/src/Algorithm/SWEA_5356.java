package Algorithm;

import java.util.Scanner;

public class SWEA_5356 {
	public static void main(String[] args) {
		
		// ��ĳ�� ���� �� testCase ���� �Է¹ް� �׸�ŭ �ݺ�
		Scanner sc = new Scanner(System.in);
		
		// ����� ����ϱ� ���� StringBuffer ����
		StringBuffer sb = new StringBuffer();
		
		// testCase �Է¹ް� �ݺ�
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 0; tc<testCase; tc++) {
			// stringBuffer�� testCase���� �տ� �ٴ� �� �̸� ����
			sb.append("#"+(tc+1)+" ");
			
			// 5���� ���ڿ��� �޴´� ( char�� �迭�� )
			// ���� first, second ... fifth��� ����
			char[] first, second, third, fourth, fifth;
			first = sc.nextLine().toCharArray();
			second = sc.nextLine().toCharArray();
			third = sc.nextLine().toCharArray();
			fourth = sc.nextLine().toCharArray();
			fifth = sc.nextLine().toCharArray();
			
			// �� ���ڿ��� ���� firLen, secLen ... fifLen
			int firLen, secLen, thiLen, fouLen, fifLen;
			firLen = first.length;
			secLen = second.length;
			thiLen = third.length;
			fouLen = fourth.length;
			fifLen = fifth.length;
			
			// ���ڿ��� ���� �� �ִ밪 Maxlen
			int Maxlen = Math.max(firLen, secLen);
			Maxlen = Math.max(Maxlen, thiLen);
			Maxlen = Math.max(Maxlen, fouLen);
			Maxlen = Math.max(Maxlen, fifLen);
			
			// ���� �� ���ڿ��� ���̸�ŭ �ݺ��ؼ� ������ ����
			// �ε����� 1�� �÷����鼭, �ش� �ε�������
			// ���ڿ��� ���̰� �ʰ����� �ʾ� ����� �� �ִٸ�
			// �ش� �ε��� ��ȣ�� �ش��ϴ� ���ڸ� ���
			for (int i = 0; i<Maxlen; i++) {
				if (i < firLen) sb.append(first[i]);
				if (i < secLen) sb.append(second[i]);
				if (i < thiLen) sb.append(third[i]);
				if (i < fouLen) sb.append(fourth[i]);
				if (i < fifLen) sb.append(fifth[i]);
				
			}
			// ���๮�� �Է�
			sb.append("\n");
		}
		// ������
		System.out.print(sb);
	}
}
