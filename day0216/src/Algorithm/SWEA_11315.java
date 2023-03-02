package Algorithm;

import java.util.Scanner;

public class SWEA_11315 {
	
	public static int size;
	
	public static void main(String[] args) {
		
		// ��ĳ�ʸ� �̿��� testCase ������ �Է¹ް� �׸�ŭ �ݺ�
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		/*
		 * �⺻ idea
		 * �迭�� boolean���� �����
		 * ���� ������ true
		 * ���� ������ false
		 * 
		 * ��, ��, �밢�� ���ؼ� true�� �������� 5��(�Ǵ� �� �̻�) ������ YES, break
		 * ��� ��쿡 ���ؼ� ������ NO
		 */
		here : for (int tc = 0; tc<testCase; tc++) {
			size = sc.nextInt();
			sc.nextLine();
			boolean[][] grid = new boolean[size][size];
			
			// grid�� �Է� �ޱ�
			for (int i = 0; i<size; i++) {
				String inputStr = sc.nextLine();
				for (int j = 0; j<size; j++) {
					if (inputStr.charAt(j) == 'o') grid[i][j] = true;
				}
			}
		
			// 5�� �������� üũ ����
			// ��
			for (int i = 0; i<size; i++) {
				int cnt = 0;
				for (int j = 0; j<size; j++) {
					// ���� ���� �ִٸ� cnt�� �ø���
					// ���� ���ٸ� cnt�� �ʱ�ȭ��Ŵ
					// ���� 5���� �Ǵ� ���� ������ �������� ���� �׽�Ʈ���̽� ����
					if (grid[i][j]) cnt++;
					else cnt = 0;
					if (cnt == 5) {
						sb.append("#"+(tc+1)+" YES\n");
						continue here;
					}
				}
			}
			// ��
			for (int i = 0; i<size; i++) {
				int cnt = 0;
				for (int j = 0; j<size; j++) {
					if (grid[j][i]) cnt++;
					else cnt = 0;
					if (cnt == 5) {
						sb.append("#"+(tc+1)+" YES\n");
						continue here;
					}
				}
			}
			// �밢 �����ʾƷ���
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					// ������� üũ
					if(borderCheck(i+4, j+4)) {
						// �������� 5���� �ִ��� Ȯ��, �ִٸ� ������ �������� ���� �׽�Ʈ���̽�
						if(grid[i][j]&&grid[i+1][j+1]&&grid[i+2][j+2]&&grid[i+3][j+3]&&grid[i+4][j+4]){
							sb.append("#"+(tc+1)+" YES\n");
							continue here;
						}
						else continue;
					}
					else continue;
				}
			}
			// �밢 ���ʾƷ���
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					if(borderCheck(i-4, j+4)) {
						if(grid[i][j]&&grid[i-1][j+1]&&grid[i-2][j+2]&&grid[i-3][j+3]&&grid[i-4][j+4]){
							sb.append("#"+(tc+1)+" YES\n");
							continue here;
						}
						else continue;
					}
					else continue;
				}
			}
			sb.append("#"+(tc+1)+" NO\n");
		}
		System.out.println(sb);
	}
	
	// ��������� üũ�ϴ� �޼���
	public static boolean borderCheck(int x, int y) {
		return (x>=0 && y>=0 && x<size && y<size);
	}
	
}
