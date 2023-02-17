package Algorithm;

import java.util.Scanner;

public class SWEA_1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// �׽�Ʈ ���̽� ���� : 10��
		int testCase = 10;
		for (int tc = 1; tc<=testCase; tc++) {
			
			// �� ó�� ���๮�� ������
			sc.nextLine();
			
			// ã������ ���ڿ��� ��ü ���ڿ��� char�� �迭��
			// findArr : ã������ ���ڿ��� char�� �迭
			// totalArr : ��ü ���ڿ��� char�� �迭
			char[] findArr = sc.nextLine().toCharArray();
			char[] totalArr = sc.nextLine().toCharArray();
			
			// ���� ã������ ���� ���̰� �� ��� ��ã���� 0
			if (findArr.length > totalArr.length) {
				System.out.println("#"+tc+" 0");
				continue;
			}
			
			// ���̾� ���� �˰����� ����ϱ� ���� �迭�� �ε��� ����
			// ���� ã������ ���ڿ��� ������ �ε����� �ʱ�ȭ
			// totalIdx : (��ü ���ڿ��� ���� �ε����� ����)
			// findIdx : (ã������ ���ڿ��� ���� �ε����� ����)
			int findIdx = findArr.length-1;
			int totalIdx = findArr.length-1;
			
			// ���ڰ� ������ Ȯ���ϱ� ���� �ε����� 1�� �ø��� �迭�� Ž���ϱ����� ����
			int tmpIdx = 0;
			
			// ã�� ���ڿ� ��
			int cnt = 0;

			/*
			 * ���̾� ���� �˰���
			 * 
			 * (��ü ���ڿ��� ���� �ε����� ����) �� 
			 * (ã������ ���ڿ��� �� �� ����)�� ���ؼ� ������
			 * ã������ ���ڿ��� ���ԵǾ� ���� ���ɼ��������Ƿ�
			 * ã������ ���ڿ��� �ε����� �ٿ����� ������Ž��
			 * 
			 * �ε����� �ٿ����� Ž���ߴµ� ã������ ���ڰ� �ƴ϶��,
			 * ( ��ü ���ڿ��� ���� �ε����� ���� ) ��
			 * ( ã������ ���ڿ� ) �� ���ԵǾ� �ִ��� Ȯ���ؼ�
			 * ���ԵǾ��ִٸ�, �׸�ŭ�� jump
			 * ���ԵǾ����� �ʴٸ�, ã������ ���ڿ��� ���̸�ŭ jump
			 * 
			 * �ε����� �ٿ����� Ž���� �Ϸ��߰�,
			 * ���� ã������ ���ڿ��� ������, 
			 * cnt�� 1 �ø���, �������� �ʱ�ȭ ���� ��
			 * ��ü ���ڿ��� (ã�����¹��ڿ��� ����)��ŭ ������������ �ٽ� Ž�� 
			 * 
			 * ( ��ü ���ڿ��� ���� �ε��� ) �� �迭�� ������ ����� ����
			 */
			here: while(totalIdx < totalArr.length) {
				// ���ڿ��� ã�� ���
				if (tmpIdx > findIdx) {
						cnt++; 
						findIdx = findArr.length -1; 
						totalIdx += findArr.length;
						tmpIdx = 0;
						continue;
					}
				// �� �� ���ڰ� �����ϰ�, ���ڿ��� ã�� �ִ� ���
				if (totalArr[totalIdx-tmpIdx] == findArr[findIdx-tmpIdx]) {
					tmpIdx ++;
					continue;
				} 
				// �� �� ���ڰ� �ٸ��ٸ� jump
				else {
					for (int i = 1; i<=findIdx; i++) {
						// ( ��ü ���ڿ��� ���� �ε����� ���� ) �� ���� : �׸�ŭ�� jump
						if (totalArr[totalIdx] == findArr[findIdx-i]) {
							totalIdx += i;
							findIdx = findArr.length -1;
							tmpIdx = 0;
							continue here;
						} 
					}
					// ( ��ü ���ڿ��� ���� �ε����� ���� ) �� ����X : ���ڿ����̸�ŭ jump
					findIdx = findArr.length -1; 
					totalIdx += findArr.length;
					tmpIdx = 0;
				}
			}
			// ��� ���
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
