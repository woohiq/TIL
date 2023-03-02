package Algorithm;

import java.util.Scanner;

public class SWEA_1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 개수 읽기
		int tc = sc.nextInt();
		
		// 테스트 케이스 개수만큼 반복
		for (int i = 0; i<tc; i++) {
			// 다음 정수값 하나 안읽고 버림
			sc.nextInt();
			// 빈도 수 저장할 변수 scores
			int[] scores = new int[101];
			// 빈도 수 저장
			for (int j = 0; j<1000; j++) {
				int score = sc.nextInt();
				scores[score]++;
			}
			// 최대 빈도수 max, 그 빈도수를 갖는 수 maxIdx
			int max = 0;
			int maxIdx = 0;
			for (int k = 100; k>=0; k--) {
				if (max < scores[k]) {
					max = scores[k];
					maxIdx = k;
				}
			}
			// 출력
			sb.append("#"+(i+1)+" "+maxIdx+"\n");
		}
		System.out.println(sb);
	}
}
