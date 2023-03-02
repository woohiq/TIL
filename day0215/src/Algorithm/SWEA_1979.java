package Algorithm;

import java.util.Scanner;

public class SWEA_1979 {
	public static void main(String[] args) {
		// ��ĳ�ʿ� ��Ʈ�� ���� ����
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ ���̽� ���� �ް�
		int test_case = sc.nextInt();
		
		// �׽�Ʈ ���̽� �� ��ŭ �ݺ�
		for (int tc = 0; tc<test_case; tc++) {
			
			// size : �迭�� ũ��
			// length : �� �� �ִ��� ã�ƾ� �ϴ� ���ڿ��� ����
			int size = sc.nextInt();
			int length = sc.nextInt();
			
			// ���� �迭�� size�� ũ��� ����
			// �޾ƾ� �ϴ� ������ 0�� 1���̹Ƿ� ���� int���� �ʿ� ���� boolean�迭�� ���
			// �� ���ܿ� padding�� �ξ� �ڿ������� ������� üũ�� �� �� �ֵ���
			boolean[][] grid = new boolean[size+2][size+2];
			
			// �Է��� �迭�� ����
			for (int i = 1; i<=size; i++) {
				for (int j = 1; j<=size; j++) {
					int in = sc.nextInt();
					if (in == 1) grid[i][j] = true;
				}
			}
			
			// cnt : ���ڿ��� �� �� �ִ� ���� ���� ����
			// tmpSum : �迭�� ���鼭 ���ӵ� 1�� ������ ���� �ӽ� ����
			int cnt = 0;
			int tmpSum = 0;
			
			// ���� ���鼭 �迭�� ũ�⸦ ����
			// �� ��, �� ���ܿ� padding�� �����Ƿ� 
			// 1���� size+1���� ���� �ȴ�
			// ��� 0���� size+1���� ���Ƶ� �Ǵµ�
			// 0�� üũ�� �ʿ䰡 �����Ƿ� (���� ����->������, ���� ��->�Ʒ��� ������ �߱� ����)
			for (int i = 1; i<=size+1; i++) {
				for (int j = 1; j<= size+1; j++) {
					// ���� �迭�� 1�̸� �ӽ� �������� 1 �ø���
					// �迭�� 0�̶�� ���ӵ� 1�� ������ ����Ǿ����Ƿ�
					// ���ڿ��� ���̿� ���ؼ� ������ cnt�� �ø��� �ƴϸ� ������ �ʱ�ȭ
					if (grid[i][j]) tmpSum++;
					else if (tmpSum == length) {cnt++; tmpSum = 0;}
					else tmpSum = 0;
				}
			}
			// �� üũ (��� ��������)
			for (int i = 1; i<=size+1; i++) {
				for (int j = 1; j<= size+1; j++) {
					if (grid[j][i]) tmpSum++;
					else if (tmpSum == length) {cnt++; tmpSum = 0;}
					else tmpSum = 0;
				}
			}
			
			// ��� ���
			sb.append("#"+(tc+1)+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}
