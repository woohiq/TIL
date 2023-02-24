package Algorithm;

import java.util.Scanner;

public class SWEA_6190 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 입력받아 그만큼 반복
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// 입력받을 수의 개수 N
			int N = sc.nextInt();
			
			// 입력을 배열에 저장
			int[] inputs = new int[N];
			for (int i = 0; i<N; i++) {
				inputs[i] = sc.nextInt();
			}
			
			// 최대값을 찾기 위한 변수
			int maximum = Integer.MIN_VALUE;
			
			// 모든 i, j (0 <= i < j < N) 쌍에 대해 다음을 검사
			// 1. Ai x Aj 값이 단조증가수인지
			// 2. 단조증가수라면, 최대값보다 큰지
			for (int i = 0; i<N-1; i++) {
				for (int j = i+1; j<N; j++) {
					
					// 단조증가를 판단하기 위해 가장 마지막 (오른쪽) 자리 수 부터 검사
					int out = inputs[i]*inputs[j];
					int lastDigit = out%10;
					
					// 단조증가수가 아니라면 valid를 false로 만들어서 break 할 것
					boolean valid = true;
					
					// 모든 자리 수가 검사될 수 있도록 함
					while(out / 10 != 0) {
						out /= 10;
						
						int currentDigit = out%10;
						// 만약 오른쪽 자리 숫자보다 왼쪽 자리수가 크다면 (단조증가가 아님)
						// valid를 false로 만들고 break
						if (currentDigit > lastDigit) {
							valid = false;
							break;
							// 일단 현재 오른쪽 자리 수가 왼쪽 자리수보다 크거나 같다면, 반복 계속
						} else {
							lastDigit = currentDigit;
						}
					}
					// 단조증가수이고 최대값보다 크다면 최대값 수정
					if (valid && maximum < inputs[i]*inputs[j]) maximum = inputs[i]*inputs[j];
				}
			}
			// 결과 출력
			if (maximum == Integer.MIN_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(maximum);
			}
		}
	}
}
