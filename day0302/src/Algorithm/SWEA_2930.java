package Algorithm;

import java.util.Scanner;

public class SWEA_2930 {
	public static void main(String[] args) {
		
		// 스캐너와 스트링 버퍼
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트케이스 입력받기
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			sb.append("#"+(tc+1));
			
			// 크기가 N인 배열 선언 , 이 배열을 heap처럼 생각함
			int N = sc.nextInt();
			int[] heap = new int[N+1];
			int size = 0;
			
			// 만약 삽입 명령어라면,
			// heap의 size(원소가 들어있는 노드의 수)를 1 늘리면서 원소를 넣기
			for (int i = 0; i<N; i++) {
				int command = sc.nextInt();
				if (command == 1) {
					int input = sc.nextInt();
					heap[++size] = input;
					int cur = size;
					
					// 만약 넣은 원소보다 부모의 원소가 작다면 계속 바꾸어나가기
					while(cur > 1 && heap[cur] > heap[cur/2]) {
						int tmp = heap[cur];
						heap[cur] = heap[cur/2];
						heap[cur/2] = tmp;
						cur/=2;
					}
					
					// 삭제 명령이라면 삭제하고, size 를 인덱스로 갖는 원소 ( 마지막원소 ) 를 최상단으로
				} else if (command == 2) {
					if (size == 0) sb.append(" "+-1);
					else {
						sb.append(" "+heap[1]);
						heap[1] = heap[size--];
						int cur = 1;
						
						// 부모의 원소보다 자식의 원소가 크다면, 부모의 원소를 자식 중 가장 큰 애로 바꿈
						while(cur <= size/2 && (heap[cur] < heap[cur*2] || heap[cur] < heap[cur*2+1])) {
							int max = (heap[cur*2]<heap[cur*2+1]) ? cur*2+1 : cur*2;
							int tmp = heap[cur];
							heap[cur] = heap[max];
							heap[max] = tmp;
							cur = max;
							
						}
					}
				}
			}
			
			// 결과 출력
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
