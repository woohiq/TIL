package Algorithm;

import java.util.Scanner;

public class SWEA_2001 {
	public static void main(String[] args) {
		
		// ��ĳ�� ����
		Scanner sc = new Scanner(System.in);
		
		// �׽�Ʈ ���̽� ���� �Է¹ް� �׸�ŭ �ݺ�
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// ��ü �迭�� ũ�� size
			// �ĸ�ä�� ũ�� flapperSize
			int size = sc.nextInt();
			int flapperSize = sc.nextInt();
			
			// �迭�� �����ؼ� �Է��� ����
			int[][] grid = new int[size][size];
			
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			
			// �ִ밪�� �����ϱ� ���� ����
			int maximum = Integer.MIN_VALUE;
			
			// �迭�� ���鼭 �����յ��� ��� �� �ִ밪�� ��
			for (int i = 0; i<size-flapperSize+1; i++) {
				for (int j = 0; j<size-flapperSize+1; j++) {
					// ������ ���� tmp
					int tmp = 0;
					for (int k = 0; k<flapperSize; k++) {
						for (int l = 0; l<flapperSize; l++) {
							// �����տ� �ĸ�ä ������ŭ�� ������ ���� ���ؼ� ���
							tmp += grid[i+k][j+l];
						}
					}
					// �ִ� �Ǻ�
					if (tmp > maximum) maximum = tmp;
				}
			}
			// ��� ���
			System.out.println("#"+(tc+1)+" "+maximum);
		}
	}
}
