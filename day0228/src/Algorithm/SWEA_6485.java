package Algorithm;

import java.util.Scanner;

public class SWEA_6485 {
	public static void main(String[] args) {
		
		// 스캐너 선언 및 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 입력받아 그만큼 반복
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			// 스트링버퍼에 테스트케이스 기입
			sb.append("#"+(tc+1));
			
			// 버스 개수 busNum
			int busNum = sc.nextInt();
			
			// 버스정류장은 총 5001개 (5000번째 인덱스까지 만드려고 +1)
			// 배열의 인덱스는 (버스정류장의 번호)
			// 들어가는 원소는 (해당 버스정류장을 지나는 버스의 개수)
			int[] busStop = new int[5001];
			
			// 만약 버스가 A ~ A+B까지 다닌다면
			// busStop[A] += 1
			// busStop[A+1] += 1
			// busStop[A+2] += 1
			// ...
			// busStop[A+B] += 1
			for (int i = 0; i<busNum; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				for (int j = start; j<=end; j++) {
					busStop[j]++;
				}
			}
			
			// 찾아야 하는 버스정류장의 수 P
			int P = sc.nextInt();
			
			// 해당 버스정류장을 지나는 버스의 개수를 출력
			for (int i = 0; i<P; i++) {
				int in = sc.nextInt();
				sb.append(" "+busStop[in]);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
		
	}
}
