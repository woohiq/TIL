package Algorithm;

import java.util.Scanner;

public class SWEA_1208 {
	public static void main(String[] args) {
		
		// ����� ����
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ���̽� : 10��
		int test_case = 10;
		for (int tc = 0; tc<test_case; tc++) {
			
			// dump���� �Է� �޾Ƽ� �׸�ŭ �ݺ�
			int dumpNum = sc.nextInt();
			// ���� ���� : 100��
			int[] ground = new int[100];
			for (int i = 0; i<100; i++) {
				ground[i] = sc.nextInt();
			}
			
			/*
			 * dump ����
			 * base idea
			 * 1. �ִ� �ּҸ� ã�´�
			 * 2. �ִ밪���� 1�� �� �� �ּҰ��� 1�� ���� 
			 * 3. dumpȽ����ŭ �ݺ�
			 */
			for (int j = 0; j<dumpNum; j++) {
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int maxIdx = 0;
				int minIdx = 0;
				for (int k = 0; k<100; k++) {
					if (ground[k] > max) {
						max = ground[k];
						maxIdx = k;
					}
					if (ground[k] < min) {
						min = ground[k];
						minIdx = k;
					}
				}
				ground[maxIdx]--;
				ground[minIdx]++;
			}
			
			// dump �Ϸ� �� �ִ� �ּ� ���� ���� ��ȯ
			// �ϴ� �ִ�, �ּҰ� ã�� ������
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int maxIdx = 0;
			int minIdx = 0;
			for (int k = 0; k<100; k++) {
				if (ground[k] > max) {
					max = ground[k];
					maxIdx = k;
				}
				if (ground[k] < min) {
					min = ground[k];
					minIdx = k;
				}
			}
			
			// ������
			sb.append("#"+(tc+1)+" "+(max-min)+"\n");
		}
		System.out.println(sb);
	}
}
