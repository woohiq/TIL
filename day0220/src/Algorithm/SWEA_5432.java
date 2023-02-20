package Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) {
		
		// 스캐너 선언 후 testCase 입력받고 그만큼 반복
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.nextLine();
		
		// 스택을 만들어서 확인
		for (int tc = 0; tc<testCase; tc++) {
			String str = sc.nextLine();
			Stack<Character> stack = new Stack<>();

			// 정답을 표시할 변수 answer
			int answer = 0;
			
			// 일단 하나 넣고 시작
			stack.push(str.charAt(0));
			
			/*
			 * 입력에 따라 다음과 같이 3가지 경우로 나눈다
			 * 1.  () 인지 체크하고, ()라면 큐의 길이만큼 +
			 * 2.  ( 이면 큐에 추가
			 * 3.  )이면 큐에 있던 애 하나 빼기, 그리고 1만큼 +
			 */
			for (int i = 1; i<str.length(); i++) {
				char currentChar = str.charAt(i);
				char lastChar = str.charAt(i-1);
				if (currentChar == ')' && lastChar == '(') {
					stack.pop();	
					answer += stack.size();
				} else if (currentChar == '(') {
					stack.push(currentChar);
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
						answer++;
					}
				}
			}
			// 결과 출력
			System.out.println("#"+(tc+1)+" "+answer);
		}
	}
}
