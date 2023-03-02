package Algorithm;

import java.util.Scanner;

public class SWEA_1216 {
	
	public static char[][] grid;
	public static int max;
	
	public static void main(String[] args) {
		
		// ��ĳ�ʿ� ��Ʈ�� ���� ����
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ ���̽� : 10��, �׸�ŭ �ݺ�
		int testCase = 10;
		for (int tc = 0; tc<testCase; tc++) {
			sc.nextLine();
			
			// (�ִ� ȸ�� ����-1) max
			max = 0;
			
			// �������� ũ��� 100 * 100
			grid = new char[100][0];
			for (int i = 0; i<100; i++) {
				grid[i] = sc.nextLine().toCharArray();
			}
			
			/*
			 * � ��ǥ X, Y�� ����
			 * (X, Y)�� �ִ� ���ҿ�
			 * (X, Y+1)�� �ִ� ���� ���� ���ٸ� 
			 * ���� 2��ŭ�� ȸ���� Ȯ��, �� �� ȸ���� ���ɼ� ����
			 * 
			 * (X, Y-1)�� �ִ� ���ҿ�
			 * (X, Y+1)�� �ִ� ���� ���� ���ٸ� 
			 * ���� 3��ŭ�� ȸ���� Ȯ��, �� �� ȸ���� ���ɼ� ����
			 * 
			 * ���� ��� ȣ���Ѵ�
			 */
			for (int i = 1; i<99; i++) {
				for (int j = 1; j<99; j++) {
					if (grid[i][j-1] == grid[i][j+1]) {
						palindromeCheck('R', i, j-1, j+1);
					} if (grid[i][j] == grid[i][j+1]) {
						palindromeCheck('R', i, j, j+1);
					} if (grid[i-1][j] == grid[i+1][j]) {
						palindromeCheck('C', j, i-1, i+1);
					} if (grid[i][j] == grid[i+1][j]) {
						palindromeCheck('C', j, i, i+1);
					}
				}
			}
			// ��� ���
			sb.append("#"+(tc+1)+" "+(max+1)+"\n");
		}
		System.out.println(sb);
	}
	
	// ��ǥ�� �迭�� �ε��� �ȿ� �ִ��� Ȯ���ϴ� �޼���
	public static boolean borderCheck(int x, int y) {
		return (x>=0 && y>=0 && x<100 && y<100);
	}
	
	// ��� ȣ���ϴ� �Լ�
	// type : row���� column����
	// other : ���� ������� �ʴ� ���� �ε���( row�ΰ�� column�� �� ��ȣ , vice versa )
	// start, end : ȸ���� �����ϰ� ������ �ε���
	public static void palindromeCheck(char type, int other, int start, int end) {
		if (max < (end-start)) max = (end-start);
		if (type == 'R') {
			if (!borderCheck(start-1, end+1) || grid[other][start-1]!=grid[other][end+1]) return;
			else palindromeCheck(type, other, start-1, end+1);
		} else {
			if (!borderCheck(start-1, end+1) || grid[start-1][other]!=grid[end+1][other]) return;
			else palindromeCheck(type, other, start-1, end+1);
		}
	}
}
