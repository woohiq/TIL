package Algorithm;

import java.util.Scanner;

public class SWEA_1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수 : 10개
		int testCase = 10;
		for (int tc = 1; tc<=testCase; tc++) {
			
			// 맨 처음 개행문자 버리기
			sc.nextLine();
			
			// 찾으려는 문자열과 전체 문자열을 char형 배열로
			// findArr : 찾으려는 문자열의 char형 배열
			// totalArr : 전체 문자열의 char형 배열
			char[] findArr = sc.nextLine().toCharArray();
			char[] totalArr = sc.nextLine().toCharArray();
			
			// 만약 찾으려는 문자 길이가 더 길면 못찾으니 0
			if (findArr.length > totalArr.length) {
				System.out.println("#"+tc+" 0");
				continue;
			}
			
			// 보이어 무어 알고리즘을 사용하기 위해 배열의 인덱스 설정
			// 각각 찾으려는 문자열의 마지막 인덱스로 초기화
			// totalIdx : (전체 문자열의 현재 인덱스의 문자)
			// findIdx : (찾으려는 문자열의 현재 인덱스의 문자)
			int findIdx = findArr.length-1;
			int totalIdx = findArr.length-1;
			
			// 문자가 같은지 확인하기 위해 인덱스에 1씩 늘리며 배열을 탐색하기위한 변수
			int tmpIdx = 0;
			
			// 찾은 문자열 수
			int cnt = 0;

			/*
			 * 보이어 무어 알고리즘
			 * 
			 * (전체 문자열의 현재 인덱스의 문자) 와 
			 * (찾으려는 문자열의 맨 뒤 문자)와 비교해서 같으면
			 * 찾으려는 문자열이 포함되어 있을 가능성이있으므로
			 * 찾으려는 문자열의 인덱스를 줄여가며 같은지탐색
			 * 
			 * 인덱스를 줄여가며 탐색했는데 찾으려는 문자가 아니라면,
			 * ( 전체 문자열의 현재 인덱스의 문자 ) 가
			 * ( 찾으려는 문자열 ) 에 포함되어 있는지 확인해서
			 * 포함되어있다면, 그만큼만 jump
			 * 포함되어있지 않다면, 찾으려는 문자열의 길이만큼 jump
			 * 
			 * 인덱스를 줄여가며 탐색을 완료했고,
			 * 만약 찾으려는 문자열이 있으면, 
			 * cnt를 1 올리고, 변수들을 초기화 해준 후
			 * 전체 문자열을 (찾으려는문자열의 길이)만큼 떨어진곳부터 다시 탐색 
			 * 
			 * ( 전체 문자열의 현재 인덱스 ) 가 배열의 범위를 벗어나면 종료
			 */
			here: while(totalIdx < totalArr.length) {
				// 문자열을 찾은 경우
				if (tmpIdx > findIdx) {
						cnt++; 
						findIdx = findArr.length -1; 
						totalIdx += findArr.length;
						tmpIdx = 0;
						continue;
					}
				// 맨 뒤 문자가 동일하고, 문자열을 찾고 있는 경우
				if (totalArr[totalIdx-tmpIdx] == findArr[findIdx-tmpIdx]) {
					tmpIdx ++;
					continue;
				} 
				// 맨 뒤 문자가 다르다면 jump
				else {
					for (int i = 1; i<=findIdx; i++) {
						// ( 전체 문자열의 현재 인덱스의 문자 ) 가 포함 : 그만큼만 jump
						if (totalArr[totalIdx] == findArr[findIdx-i]) {
							totalIdx += i;
							findIdx = findArr.length -1;
							tmpIdx = 0;
							continue here;
						} 
					}
					// ( 전체 문자열의 현재 인덱스의 문자 ) 가 포함X : 문자열길이만큼 jump
					findIdx = findArr.length -1; 
					totalIdx += findArr.length;
					tmpIdx = 0;
				}
			}
			// 결과 출력
			System.out.println("#"+tc+" "+cnt);
		}
	}
}
