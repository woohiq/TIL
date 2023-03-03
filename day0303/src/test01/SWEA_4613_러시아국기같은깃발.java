package test01;

import java.util.Scanner;

public class SWEA_4613_러시아국기같은깃발 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			
			char[][] flag = new char[row][col];
			for (int i = 0; i<row; i++) {
				String str = sc.next();
				char[] arr = str.toCharArray();
				for (int j = 0; j<col; j++) {
					flag[i][j] = arr[j];
				}
			}

			int min = Integer.MAX_VALUE;
			
			
			for (int i = 1; i<row-1; i++) {
				for (int j = i+1; j<row; j++) {
					
					int cnt = 0;
					
					for (int k = 0; k<i; k++) {
						for (int l = 0; l<col; l++) {
							if (flag[k][l] != 'W') cnt++;
						}
					}
					for (int k = i; k<j; k++) {
						for (int l = 0; l<col; l++) {
							if (flag[k][l] != 'B') cnt++;
						}
					}
					for (int k = j; k<row; k++) {
						for (int l = 0; l<col; l++) {
							if (flag[k][l] != 'R') cnt++;
						}
					}
					if (cnt<min) min = cnt;
				}
			}
			System.out.println("#"+(tc+1)+" "+min);
		}
	}
}
