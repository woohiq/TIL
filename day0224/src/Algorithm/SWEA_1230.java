package Algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1230 {
	public static void main(String[] args) {
		
		// 스캐너와 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 : 10개
		for (int tc = 0; tc<10; tc++) {
			
			// 삽입과 삭제가 빈번하게 일어나므로
			// linkedlist를 이용한다
			LinkedList<Integer> list = new LinkedList<>();
			
			// 맨 처음 암호문의 길이
			int N = sc.nextInt();
			
			// 암호문의 길이만큼 그 원소들을 linkedlist에 저장
			for (int i = 0; i<N; i++) {
				list.add(sc.nextInt());
			}
			
			// 명령어의 개수
			int commandNum = sc.nextInt();
			
			// 명령어가 어떤 것인지 판단
			for (int i = 0; i<commandNum; i++) {
				char commandChar = sc.next().charAt(0);
				
				/*
				 * 만약 명령어가 I라면,
				 * index의 위치에 count만큼의 숫자를 넣어야 한다
				 * 근데 숫자가 하나 들어갈때마다 index가 하나 밀리게 된다
				 * (해당 index에 내가 숫자를 하나씩 넣기 때문에)
				 * 따라서 index를 늘려가면서 linkedlist의 중간에 삽입
				 */
				if (commandChar == 'I') {
					int index = sc.nextInt();
					int count = sc.nextInt();
					for (int j = 0; j<count; j++) {
						list.add(index++, sc.nextInt());
					}
					/*
					 * 명령어가 D라면, 해당 index위치에 count만큼의 원소를 삭제
					 * 삭제 명령의 경우, 계속해도 인덱스가 밀리거나 하지 않는다
					 */
				} else if (commandChar == 'D' ) {
					int index = sc.nextInt();
					int count = sc.nextInt();
					for (int j = 0; j<count; j++) {
						list.remove(index);
					}
					/*
					 * 명령어가 A라면, 암호문의 맨 뒤에 숫자를 count만큼 붙이기
					 * addLast명령어를 이용한다
					 */
				} else if (commandChar == 'A') {
					int count = sc.nextInt();
					for (int j = 0; j<count; j++) {
						list.addLast(sc.nextInt());
					}
				}
			}
			// 맨 앞 10개의 원소만 출력
			sb.append("#"+(tc+1));
			for (int i = 0; i<10; i++) {
				sb.append(" "+list.pop());
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
