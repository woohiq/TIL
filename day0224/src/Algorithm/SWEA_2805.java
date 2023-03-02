package Algorithm;

import java.util.Scanner;

public class SWEA_2805 {
	public static void main(String[] args) {
		
		// 스캐너와 스트링버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트케이스를 입력받고 그만큼 반복
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// 땅의 가로,세로 크기 : size
			int size = sc.nextInt();
			sc.nextLine();
			
			// size * size 크기의 땅을 표시할 배열 ground 선언 
			char[][] ground = new char[size][0];
			
			// ground 안에 값 채우기
			for (int i = 0; i<size; i++) {
				ground[i] = sc.nextLine().toCharArray();
			}
			
			// ground의 중앙 좌표 middle
			int middle = size/2;
			
			int answer = 0;
			
			// 만약 중앙 좌표 (middle, middle)과 택시거리가 middle이하라면 
			// 마름모 꼴 모양에 포함되므로 answer에 해당 영역의 값 추가
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					if (Math.abs(middle-i)+Math.abs(middle-j)<=middle) {
						answer += (int)(ground[i][j]-'0');
					}
				}
			}
			
			// 정답 출력
			sb.append("#"+(tc+1)+" "+answer+"\n");
		}
		System.out.print(sb);
	}
}
