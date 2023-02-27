package Algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1228 {
	public static void main(String[] args) {
		// 스캐너 및 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트케이스 : 10개, 테스트케이스만큼 반복
		for (int tc = 0; tc<10; tc++) {
			
			// 스트링버퍼의 맨 앞에 해당 테스트케이스 입력
			sb.append("#"+(tc+1));
			
			// 맨 처음 암호의 개수 N
			int N = sc.nextInt();
			
			// 링크드리스트를 선언해서 암호의 개수만큼 입력을 받아 저장
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i = 0; i<N; i++) {
				list.offer(sc.nextInt());
			}
			
			// 명령어의 개수 commands
			int commands = sc.nextInt();
			
			// 명령어의 맨 앞이 I라면 insert 연산
			// 넣어야하는 인덱스와, 넣어야 하는 암호의 개수를 입력받아
			// 해당 인덱스에 암호를 삽입함
			// 이 때, 인덱스가 하나씩 밀리므로 index는 후위연산자를 통해 1씩 증가시킴
			for (int i = 0; i<commands; i++) {
				if (sc.next().equals("I")) {
					int index = sc.nextInt();
					int numberCount = sc.nextInt();
					for (int j = 0; j<numberCount; j++) {
						list.add(index++, sc.nextInt());
					}
				}
			}
			
			// 앞에서부터 10개의 암호 출력
			for (int i = 0; i<10; i++) {
				sb.append(" "+list.poll());
			}
			sb.append("\n");
		
		// 결과 출력
		}
		System.out.print(sb);
	}
}
