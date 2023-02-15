package Algorithm;

import java.util.Scanner;

public class SWEA_1979 {
	public static void main(String[] args) {
		// 스캐너와 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 개수 받고
		int test_case = sc.nextInt();
		
		// 테스트 케이스 수 만큼 반복
		for (int tc = 0; tc<test_case; tc++) {
			
			// size : 배열의 크기
			// length : 들어갈 수 있는지 찾아야 하는 문자열의 길이
			int size = sc.nextInt();
			int length = sc.nextInt();
			
			// 따라서 배열을 size의 크기로 선언
			// 받아야 하는 정보는 0과 1뿐이므로 굳이 int형쓸 필요 없이 boolean배열로 사용
			// 양 끝단에 padding을 두어 자연스럽게 경계조건 체크가 될 수 있도록
			boolean[][] grid = new boolean[size+2][size+2];
			
			// 입력을 배열에 저장
			for (int i = 1; i<=size; i++) {
				for (int j = 1; j<=size; j++) {
					int in = sc.nextInt();
					if (in == 1) grid[i][j] = true;
				}
			}
			
			// cnt : 문자열이 들어갈 수 있는 곳을 세는 변수
			// tmpSum : 배열을 돌면서 연속된 1의 개수를 세는 임시 변수
			int cnt = 0;
			int tmpSum = 0;
			
			// 행을 돌면서 배열의 크기를 센다
			// 이 때, 양 끝단에 padding이 있으므로 
			// 1에서 size+1까지 돌면 된다
			// 사실 0에서 size+1까지 돌아도 되는데
			// 0을 체크할 필요가 없으므로 (행을 왼쪽->오른쪽, 열은 위->아래로 세도록 했기 때문)
			for (int i = 1; i<=size+1; i++) {
				for (int j = 1; j<= size+1; j++) {
					// 만약 배열이 1이면 임시 변수값을 1 올리고
					// 배열이 0이라면 연속된 1의 개수가 종료되었으므로
					// 문자열의 길이와 비교해서 같으면 cnt를 올리고 아니면 변수만 초기화
					if (grid[i][j]) tmpSum++;
					else if (tmpSum == length) {cnt++; tmpSum = 0;}
					else tmpSum = 0;
				}
			}
			// 열 체크 (행과 마찬가지)
			for (int i = 1; i<=size+1; i++) {
				for (int j = 1; j<= size+1; j++) {
					if (grid[j][i]) tmpSum++;
					else if (tmpSum == length) {cnt++; tmpSum = 0;}
					else tmpSum = 0;
				}
			}
			
			// 결과 출력
			sb.append("#"+(tc+1)+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}
