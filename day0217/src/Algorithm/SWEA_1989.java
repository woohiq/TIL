package Algorithm;

import java.util.Scanner;

public class SWEA_1989 {
	public static void main(String[] args) {
		
		// ��ĳ���� ��Ʈ�� ���� ����
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ���̽� ���� �Է¹ް� �׸�ŭ �ݺ�
		int testCase = sc.nextInt();
		sc.nextLine();
		
		// ȸ�� �˻� ����
		here: for (int tc = 0; tc<testCase; tc++) {
			
			// ���ڿ� �Է��� �޾� char�� �迭�� �ٲ�
			String inputStr = sc.nextLine();
			char[] inputArr = inputStr.toCharArray();
			
			// char�� �迭�� ���̿� ���ݿ� ���� ȸ�� �˻�
			// i ��° ���ҿ� (�迭�������ε��� -i)��° ���ҿ� ��
			for (int i = 0; i<inputArr.length/2; i++) {
				// ���� ���ڰ� �ٸ��ٸ�, ȸ���� �ƴϰ�, ȸ���� �ƴ϶��, 0��� �� �ش� tc���� 
				if (inputArr[i] != inputArr[inputArr.length-1-i]) {
					sb.append("#"+(tc+1)+" 0\n");
					continue here;
				}
			}
			
			// ȸ���̶��, 1���
			sb.append("#"+(tc+1)+" 1\n");
			continue;
		}
		
		// ��� ���
		System.out.println(sb);
	}
}
