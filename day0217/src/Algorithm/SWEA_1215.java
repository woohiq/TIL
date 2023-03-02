package Algorithm;

import java.util.Scanner;

public class SWEA_1215 {
	public static void main(String[] args) {
		
		// ��ĳ�ʿ� ��Ʈ�� ���� ����
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ ���̽� : 10��, �׸�ŭ �ݺ�
		int testCase = 10;
		for (int tc = 0; tc<testCase; tc++) {
			
			// ã�ƾ� �ϴ� ���ڿ��� ���� : size
			int size = sc.nextInt();
			sc.nextLine();
			
			// �������� ũ��� 8x8
			char[][] grid = new char[8][0];
			for (int i = 0; i<8; i++) {
				grid[i] = sc.nextLine().toCharArray();
			}
						
			// ȸ���� ������ �� cnt����
			int cnt = 0;
			
			// ���� Ž��
			// ���� ���̰� N�� ȸ���� ã������ �Ѵٸ�
			// A ���� ( A+ (N-1) )���� ��
			// A+1 ���� ( A+ (N-2) )���� ��
			// A+2 ���� ( A+ (N-3) )���� ��
			// ...
			// A+k ���� ( A+ (N-k-1) )���� ��
			for (int i = 0; i<8; i++) {
				here: for (int j = 0; j<=8-size; j++) {
					for (int k = 1; k<=size/2; k++) {
						if (grid[i][j+k-1] != grid[i][j+size-k]) {
							continue here;
						}
					} 
					cnt++;
				}
			}
			
			// ���� Ž��
			for (int i = 0; i<8; i++) {
				here: for (int j = 0; j<=8-size; j++) {
					for (int k = 1; k<=size/2; k++) {
						if (grid[j+k-1][i] != grid[j+size-k][i]) {
							continue here;
						}
					} cnt++;
				}
			}
			
			// ã�� ���� ���
			sb.append("#"+(tc+1)+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}
