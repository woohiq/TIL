package Algorithm;

import java.util.Scanner;

public class SWEA_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// �׽�Ʈ ���̽� ���� �б�
		int tc = sc.nextInt();
		
		// �׽�Ʈ ���̽� ������ŭ �ݺ�
		for (int i = 0; i<tc; i++) {
			// ���� ������ �ϳ� ���а� ����
			sc.nextInt();
			// �� �� ������ ���� scores
			int[] scores = new int[101];
			// �� �� ����
			for (int j = 0; j<1000; j++) {
				int score = sc.nextInt();
				scores[score]++;
			}
			// �ִ� �󵵼� max, �� �󵵼��� ���� �� maxIdx
			int max = 0;
			int maxIdx = 0;
			for (int k = 100; k>=0; k--) {
				if (max < scores[k]) {
					max = scores[k];
					maxIdx = k;
				}
			}
			// ���
			sb.append("#"+(i+1)+" "+maxIdx+"\n");
		}
		System.out.println(sb);
	}
}
