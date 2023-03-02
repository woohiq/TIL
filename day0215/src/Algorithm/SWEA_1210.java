package Algorithm;

import java.util.Scanner;

public class SWEA_1210 {
	public static void main(String[] args) {
		// ��ĳ�ʿ� StringBuffer ����
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ ���̽���ŭ �ݺ� : 10ȸ
		for (int tc = 0; tc<10; tc++) {
			// �׽�Ʈ ���̽��� ��Ÿ���� ���� ������
			sc.nextInt();
			
			// �Է��� ���� �迭 ����, 0�� 1�� 2�� �Է¹����� �ǹǷ�(2�� �� �ϳ�) boolean���� ����
			// ���� ��ǥ�� padding�� �־� �ڿ������� ��� ���� üũ�� �� �� �ֵ���
			boolean[][] grid = new boolean[100][102];
			
			// ���� �ε����� ���� �ε����� ��Ÿ�� ���� Idx
			int Idx = 0;
			
			// �Է� �ֱ�
			for (int i = 0; i<100; i++) {
				for (int j = 1; j<=100; j++) {
					int in = sc.nextInt();
					if (in == 1) grid[i][j] = true;
					// ���� �Է��� 2��� �������̸��� Idx�� �ش� ��ġ�� ���� �ε��������� ����
					// ���� �ε������� �ʿ� ���� ������ ������ ������ ���̱� ����
					else if (in == 2) Idx = j;
				}
			}
			
			// ��ٸ�Ÿ�� ����
			// ���� ��, ��� �� �� �ִٸ�
			// ���� ��ġ�� �̹� �湮�ߴٰ� �ϱ� ���� ���� ��ġ�� false�� ���� �� ��
			// Idx���� �ø��ų� �ٿ��� ��,��� �������� ����
			for (int i = 99; i>=0; i--) {
				while(grid[i][Idx+1] || grid[i][Idx-1]) {
					if (grid[i][Idx+1]) {
						grid[i][Idx++] = false;
					} else {
						grid[i][Idx--] = false;
					}
				}
			}
			
			// ��� ���
			sb.append("#"+(tc+1)+" "+(Idx-1)+"\n");	
		}
		System.out.println(sb);
	}
}
