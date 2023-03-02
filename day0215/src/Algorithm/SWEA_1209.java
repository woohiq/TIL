package Algorithm;

import java.util.Scanner;

public class SWEA_1209 {
	public static void main(String[] args) {
		
		// ��ĳ�� ����
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ���̽� 10���̹Ƿ� 10�� �ݼ�
		for (int i = 0; i<10; i++) {
			// �� ó�� ���� ������
			sc.nextInt();
			// ���� �Է��� ������ 2���� �迭 ����
			int[][] grid = new int[100][100];
			
			// ���� �Է� �ޱ�
			for (int j = 0; j<100; j++) {
				for (int k = 0; k<100; k++) {
					grid[j][k] = sc.nextInt();
				}
			}
			
			// �ִ밪�� ������ maximum ����
			// ���� ��,��,�밢 ���� ������ tmpSum
			int maximum = Integer.MIN_VALUE;
			int tmpSum = 0;
			
			// ���� �� üũ
			for (int j = 0; j<100; j++) {
				for (int k = 0; k<100; k++) {
					tmpSum += grid[j][k]; 
				}
				if (tmpSum > maximum) maximum = tmpSum;
				tmpSum = 0;
			}
			
			// ���� �� üũ
			for (int j = 0; j<100; j++) {
				for (int k = 0; k<100; k++) {
					tmpSum += grid[k][j]; 
				}
				if (tmpSum > maximum) maximum = tmpSum;
				tmpSum = 0;
			}
			
			// �밢 ������~�����Ʒ� �� üũ
			for (int j = 0; j<100; j++) {
				tmpSum += grid[j][j];
			}
			if (tmpSum > maximum) maximum = tmpSum;
			tmpSum = 0;
			
			// �밢 ������~���ʾƷ� �� üũ
			for (int j = 0; j<100; j++) {
				tmpSum += grid[j][99-j];
			}
			if (tmpSum > maximum) maximum = tmpSum;
			tmpSum = 0;
			
			// ��� ���
			sb.append("#"+(i+1)+" "+maximum+"\n");
		}
		System.out.println(sb);
	}
}
