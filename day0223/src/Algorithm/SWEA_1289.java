package Algorithm;

import java.util.Scanner;

public class SWEA_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int testCase = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc<testCase; tc++) {
			char[] input = sc.nextLine().toCharArray();
			
			char currentChar = '0';
			int cnt = 0;
			for (int i = 0; i<input.length; i++) {
				if (input[i] != currentChar) {
					cnt++;
					if (currentChar == '0') currentChar = '1';
					else currentChar = '0';
				}
			}
			sb.append("#"+(tc+1)+" "+cnt+"\n");
		}
		System.out.print(sb);
	}
}
