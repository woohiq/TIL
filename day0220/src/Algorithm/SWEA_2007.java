package Algorithm;

import java.util.Scanner;

public class SWEA_2007 {
	public static void main(String[] args) {
		/****************************************
		 * ���������� ������ �� ������ ���� �̻��ѵ�...
		 * KOREAKOREAKOREAKOREAKOREAKOREA�� ��� 
		 * ������̴� 5, 10, 20, 30 ���� �����ѵ�
		 * '�ּ�' ���� ���̸� ���϶�� ���� ��������...
		 ****************************************/
		
		// ��ĳ�� ���� �� ����� ����� StringBuffer ����
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ ���̽� ������ �޾� �׸�ŭ �ݺ�
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 0; tc<testCase; tc++) {
			// ���ڿ��� �Է¹���
			String str = sc.nextLine();
			sb.append("#"+(tc+1)+" ");
			
			// ���ڿ��� ���� ���� ã��
			// '�ּ�' ������̸� ã�ƾ���
			// ���� 1���� 10���� ������ ������� �� �ּҸ� ã��
			// ������̸��� ��� �κй��ڿ��� �����ؾ���
			here : for (int i = 1; i<=10; i++) {
				for (int j = 1; i*(j+1)<=30; j++) {
					// �������� ������ ���� ������̸� Ȯ���ϵ��� continue
					if (!str.substring((j-1)*i, j*i).equals(str.substring(j*i, (j+1)*i))) continue here;
				}
				// �����ϴٸ� ��� ���
				sb.append(i+"\n");
				break;
			}
		}
		// ��ü ��� ���
		System.out.print(sb);
	}
}
