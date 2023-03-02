package Algorithm;

import java.util.Scanner;

public class SWEA_1989 {
	public static void main(String[] args) {
		
		// 스캐나와 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트케이스 개수 입력받고 그만큼 반복
		int testCase = sc.nextInt();
		sc.nextLine();
		
		// 회문 검사 시작
		here: for (int tc = 0; tc<testCase; tc++) {
			
			// 문자열 입력을 받아 char형 배열로 바꿈
			String inputStr = sc.nextLine();
			char[] inputArr = inputStr.toCharArray();
			
			// char형 배열의 길이에 절반에 대해 회문 검사
			// i 번째 원소와 (배열마지막인덱스 -i)번째 원소와 비교
			for (int i = 0; i<inputArr.length/2; i++) {
				// 만약 문자가 다르다면, 회문이 아니고, 회문이 아니라면, 0출력 후 해당 tc종료 
				if (inputArr[i] != inputArr[inputArr.length-1-i]) {
					sb.append("#"+(tc+1)+" 0\n");
					continue here;
				}
			}
			
			// 회문이라면, 1출력
			sb.append("#"+(tc+1)+" 1\n");
			continue;
		}
		
		// 결과 출력
		System.out.println(sb);
	}
}
