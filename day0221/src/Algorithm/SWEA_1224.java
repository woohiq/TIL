package Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 : 10개
		for (int tc = 0; tc<10; tc++) {
			int inputSize = sc.nextInt();
			sc.nextLine();
			
			// 입력을 Character 타입의 배열로 전환
			// 숫자 뿐만 아니라 (,),+,-,*,/ 전부 다 있기 때문
			char[] input = sc.next().toCharArray();
			
			// 후위표기식으로 만들기 위해 스택을 사용
			Stack<Character> postfixStack = new Stack<>();
			
			// 후위표기식을 저장하기 위한 배열
			// 추후에 후위표기식의 수식값 계산을 위해 저장 
			char[] calculating = new char[inputSize];
			
			// 후위표기식을 저장하기 위한 배열의 인덱스
			// 결국 후위표기식 배열의 길이가 될 것임
			int cnt = 0;
			
			/*
			 * 입력마다 다음을 실행
			 * 
			 * 1. 만약 숫자인 경우
			 * 	후위표기식 배열에 바로 집어넣기
			 * 
			 * 2. 만약 덧셈, 뺄셈인 경우
			 * 	덧셈 뺄셈은 +, -, *, / 의 네 가지 경우가 스택의 맨 위에 있으면
			 * 	그만큼을 계속, 전부 pop하고 자신을 넣어야하므로
			 * 	다시 말하면 스택이 비었거나 '('가 맨 위에 있는 경우를 제외하고 pop한다
			 *  (닫힌 소괄호의 경우에는 스택에 들어가지 않으므로 신경쓰지 않음)
			 *  pop이 끝나면 자신을 스택에 넣음
			 * 
			 * 3. 만약 곱셈, 나눗셈인 경우
			 * 	곱셈 나눗셈은 자신보다 우선순위가 빠른 경우가
			 *  (먼저 나온 곱셈), (먼저 나온 나눗셈)뿐이므로
			 *  두 가지 경우는 계속 pop 해주고, pop이 끝나면 자신을 스택에 넣음
			 *  
			 * 4. 열린 / 닫힌 소괄호의 경우
			 * 	열린 소괄호는 무조건 스택에 넣고
			 * 	닫힌 소괄호는 열린 소괄호가 나올때까지 계속 pop,
			 *  그러나 위의 사칙연산과 다르게 pop이 끝나도 스택에 자신을 넣지 않음
			 */
			for (int i = 0; i<inputSize; i++) {
				
				// 현재 문자 : currentChar
				char currentChar = input[i];
				
				// 숫자인 경우
				if (currentChar >= '0' && currentChar <='9') {
					calculating[cnt++] = currentChar;
				} 
				// 덧셈, 뺄셈인 경우
				else if (currentChar == '+' || currentChar == '-') {
					while(!postfixStack.isEmpty() && postfixStack.peek() != '(') {
						calculating[cnt++] = postfixStack.pop();
					}
					postfixStack.push(currentChar);
				} 
				// 곱셈, 나눗셈인 경우
				else if (currentChar == '*' || currentChar == '/') {
					while(!postfixStack.isEmpty() && (postfixStack.peek() == '*' || postfixStack.peek() == '/')) {
						calculating[cnt++] = postfixStack.pop();
					}
					postfixStack.push(currentChar);
				} 
				// 열린 소괄호
				else if (currentChar == '(') {
					postfixStack.push(currentChar);
				} 
				// 닫힌 소괄호
				else {
					while(postfixStack.peek() != '(') {
						calculating[cnt++] = postfixStack.pop();
					}
					postfixStack.pop();
				}
			}
			
			// 스택에 남은 연산자들 모두 배열로
			while(!postfixStack.isEmpty()) {
				calculating[cnt++] = postfixStack.pop();
			}
			
			/*
			 * 이젠 후위표기식으로 표시된 식에 대해 실제 계산을 진행
			 * 
			 * 이번엔 반대로 숫자와 중간 계산된 숫자값들이 스택에 들어간다
			 */
			Stack<Integer> calculatingStack = new Stack<>();
			for (int i = 0; i<cnt; i++) {
				
				// 후위문자열의 현재 문자 : currentChar
				char currentChar = calculating[i];
				
				// 숫자인 경우 스택에 넣기
				if (currentChar >= '0' && currentChar <='9') {
					calculatingStack.push((int)currentChar - '0');
				} 
				
				// null문자 확인 ( 이미 cnt로 배열의 길이를 세긴 했지만... 혹시 모르니까 )
				// null문자가 아니면 사칙연산이므로 해당 사칙연산을 진행
				else if (currentChar != '\u0000') {
					
					// 숫자 두개를 스택에서 빼고
					int first = calculatingStack.pop();
					int second = calculatingStack.pop();
					
					// 사칙연산 결과를 스택에 다시 집어넣기
					if (currentChar == '+' ) calculatingStack.push(first+second);
					else if (currentChar == '-' ) calculatingStack.push(first-second);
					else if (currentChar == '*' ) calculatingStack.push(first*second);
					else if (currentChar == '/' ) calculatingStack.push(second/first);
				} 
				// null문자라면 종료
				else break;
			}
			// scanner 한줄 버리기
			sc.nextLine();
			
			// 결과 출력
			System.out.println("#"+(tc+1)+" "+calculatingStack.pop());
		}
	}
}