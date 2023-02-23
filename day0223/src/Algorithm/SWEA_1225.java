package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 개수가 명시되어 있지 않다.
		// 따라서 hasnext로 판단해야겠다
		while (sc.hasNextInt()) {
			int tc = sc.nextInt();
			sb.append("#"+tc);
			
			// 큐 선언
			Queue<Integer> queue = new LinkedList<Integer>();
			
			// 큐에 입력값 집어넣기
			for (int i = 0; i<8; i++) {
				queue.offer(sc.nextInt());
			}
			
			// break될 때 까지 사이클을 돌게 하기
			here: while(true) {
				// 한 사이클 : 
				///맨 앞수를 뽑아서 1을 뺴고 0보다 크다면 다시 큐의 맨 뒤에 넣기
				// 맨 앞수를 뽑아서 2을 뺴고 0보다 크다면 다시 큐의 맨 뒤에 넣기
				// ...
				// 맨 앞수를 뽑아서 5을 뺴고 0보다 크다면 다시 큐의 맨 뒤에 넣기
				// 0보다 작거나 같다면 break
				for (int i = 1; i <= 5; i++) {
					int currentInt = queue.poll();
					if( currentInt > i) queue.offer(currentInt-i);
					else break here;
				}
			}
			
			// 결과를 stringBuffer에 저장
			while(!queue.isEmpty()) {
				sb.append(" "+queue.poll());
			}
			
			// 마지막 수는 0이 되었다
			sb.append(" 0\n");
		}
		// 결과 출력
		System.out.println(sb);
	}
}
