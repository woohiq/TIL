package Algorithm;

import java.util.Scanner;

public class SWEA_1966 {
	public static void main(String[] args) {
		
		// 스캐너와 스트링버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트케이스 개수를 입력받아 그만큼 반복
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// 스트링버퍼에 테스트케이스 쓰기
			sb.append("#"+(tc+1));
			
			// 정렬해야하는 숫자의 개수 N
			int N = sc.nextInt();
			
			// 숫자들을 numbers라는 배열에 저장해 정렬할 것임
			int[] numbers = new int[N];
			for (int i = 0; i<N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			/* 정렬 알고리즘은 insertion sort를 사용
			 * 
			 * 정렬된 구역과 정렬되지 않는 구역으로 나누고
			 * 
			 * 정렬되지 않은 구역에서 (해당 수) 하나를 뽑아
			 * 정렬된 구역의 앞에서 부터 (자신보다 큰 정렬된 수)를 찾고
			 * 찾았다면 (해당 수) 를 (자신보다 큰  정렬된 수) 의 위치에 넣고
			 * (자신보다 큰 정렬된 수) 부터 정렬된 수가 긑날때까지 index를 1씩 뒤로 미룸
			 * 
			 * 도서관 사서가 도서관을 정리하는 모양이 될 수 있도록...
			 */
			
			// 정렬되지 않은 구역에서 수 하나 뽑기, 해당 수 : numbers[i]
			for (int i = 1; i<N; i++) {
				// 정렬된 구역들의 수 중 해당 수보다 큰 수 찾기
				// 정렬된 수들 : numbers[j]
				for (int j = 0; j<i; j++) {
					
					// 만약 정렬된 수 가 해당 수보다 크다면, 
					// 정렬된 수 자리에 해당 수를 넣고
					// 정렬된 수 부터 나머지 정렬된 수까지 모든 인덱스를 뒤로 한칸씩
					if(numbers[j] > numbers[i]) {
						// 뒤로 미룰 수 : tmp
						// 뒤로 미뤄지기 위해 임시 저장을 위한 변수 : original
						int tmp = numbers[j];
						numbers[j] = numbers[i];
						for (int k = j+1; k<=i; k++) {
							int original = numbers[k];
							numbers[k] = tmp;
							tmp = original;
						}
						break;
					}
				}
			}
			// 결과 출력
			for (int i = 0; i<N; i++) {
				sb.append(" "+numbers[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
