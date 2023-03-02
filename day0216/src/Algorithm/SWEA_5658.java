package Algorithm;

import java.util.Scanner;

public class SWEA_5658 {
	public static void main(String[] args) {
		
		// 스캐너를 이용해 입력받기
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 개수 입력받고 해당 수만큼 반복
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// N : 받을 입력의 개수
			// K : 찾을 큰수의 인덱스 ( K번째 큰 수 )
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			/*
			 * 입력을 받을 배열 numbers
			 * 입력으로 만들 수 있는 16진수 숫자들을 저장할 combinations
			 * 
			 * 입력을 받을 배열 number의 크기를 
			 * N이 아니라 N+N/4로 설정하면
			 * 단순히 인덱스를 하나 미루는 것으로
			 * 보물상자의 뚜껑의 돌아감을 구현할 수 있다
			 */
			int[] numbers = new int[N+N/4];
			int[] combinations = new int[N];
			
			String input = sc.nextLine(); 
			
			// 입력을 문자열로 받아 해당 인덱스에 있는 Character를 이용해 숫자로 변환
			// (숫자) => 그대로, A => 10, B => 11 ... 이런식
			for (int i = 0; i<N+N/4; i++) {
				int tmp = input.charAt(i%N);
				
				if (tmp >= (int)'A' && tmp <= (int)'F') tmp -= ((int)'A'-10);
				else tmp = Integer.valueOf(tmp) - '0';
				
				numbers[i] = tmp;
			}
			
			// combination에 저장할 index 변수
			int cnt = 0;
			
			/*
			 * 보물상자 뚜껑이 돌아갈 때 보물상자 뚜껑의 숫자들을 이용해 16진수 수를 만들자
			 * 
			 * 보물상자 뚜껑의 돌아간 횟수 : i회
			 * 보물상자 뚜껑은 총 N/4번만큼 돌아갈수 있다
			 * 
			 * 보물상자의 면의 인덱스 : j
			 * 보물상자의 면은 총 4개 있다
			 * 
			 * 보물상자 한 면에 존재하는 숫자들의 인덱스 : k
			 * 보물상자 한 면에는 총 N/4개의 숫자들이 존재한다
			 * 
			 * 따라서, 해당하는 면에서 만들 수 있는 16진수 수는
			 * numbers[ i + (N/4)*j + N/4-1 ] * 16^0 +
			 * numbers[ i + (N/4)*j + N/4-2 ] * 16^1 +
			 * numbers[ i + (N/4)*j + N/4-3 ] * 16^2 +
			 * ... +
			 * numbers[ i + (N/4)*j + 0 ] * 16^(N/4-1)
			 * 
			 * k가 0에서 N/4-1까지 
			 * 즉, numbers[i+N/4*j+k]*Math.pow(16, N/4-k-1); 의 합
			 */
			for (int i = 0; i<N/4; i++) {
				for (int j = 0; j<4; j++) {
					int tmp = 0;
					for (int k = 0; k<N/4; k++) {
						tmp += numbers[i+N/4*j+k]*Math.pow(16, N/4-k-1);
					}
					// 이를 조합에 저장
					combinations[cnt++] = tmp;
				}
			}
			
			/*
			 * 숫자들의 조합은 다음과 같이 내림차순 정렬한다
			 * (기본적으로 BubbleSort)
			 * 
			 * 만약 왼쪽 숫자보다 오른쪽 숫자가 더 크다면 SWAP
			 * 
			 * 만약 왼쪽 숫자와 오른쪽 숫자가 같다면 오른쪽 숫자를 0으로 만듬
			 * ( 어차피 오른쪽 수가 더 작아야 하므로 내림차순에는 문제없음 ) 
			 */
			for (int i = 0; i<combinations.length; i++) {
				for (int j = i+1; j<combinations.length; j++) {
					if (combinations[j] > combinations[i]) {
						int tmp = combinations[j];
						combinations[j] = combinations[i];
						combinations[i] = tmp;
					} else if (combinations[j] == combinations[i]) {
						combinations[j] = 0;
					}
				}
			}
			
			// 결과 출력
			System.out.println("#"+(tc+1)+" "+combinations[K-1]);
			
		}
		
	}
}
