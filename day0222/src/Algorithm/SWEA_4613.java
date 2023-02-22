package Algorithm;
import java.util.Scanner;

public class SWEA_4613 {
	public static void main(String[] args) {
		
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 개수 testCase
		int testCase = sc.nextInt();
		sc.nextLine();
		
		// 테스트 케이스만큼 반복
		for (int tc = 0; tc<testCase; tc++) {
			
			// 행의 수 N
			// 열의 수 M
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			
			// 각 줄마다 해당 색갈의 개수를 담고있는 배열 white, blue, red
			// 예를들어 white[3] 은 3번째 행에 있는 흰색 타일의 수
			int[] white = new int[N+1];
			int[] blue = new int[N+1];
			int[] red = new int[N+1];
			
			// 위에서 선언한 배열 채우기
			for (int i = 1; i<=N; i++) {
				char[] input = sc.nextLine().toCharArray();
				for (int j = 0; j<M; j++) {
					if (input[j] == 'W') white[i]++;
					else if (input[j] == 'B') blue[i]++;
					else red[i]++;
				}
			}
			
			// 채워야 하는 공간수 계산하기 위한 변수 spaceToPaint
			int spaceToPaint = 0;
			
			// 최소값 계산을 위한 변수 minimumSpace
			int minimumSpace = Integer.MAX_VALUE;
			
			/*
			 * 흰색 줄을 선택하기 시작한 행의 인덱스 : i
			 * 파랑 줄을 선택하기 시작한 행의 인덱스 : j
			 * 빨강 줄을 선택하기 시작한 행의 인덱스 : k
			 * 라고 하자, 
			 * 택할 흰색 줄의 수 i
			 * 택할 파랑 줄의 수 j - i
			 * 택할 빨강 줄의 수 k - j
			 * 
			 * 채워야 하는 공간의 수는
			 * (1번째 행의 총 타일의 개수 = 열의 수 = M) - ( 1번째 행에서 칠할 색깔의 수 )
			 * (2번째 행의 총 타일의 개수 = 열의 수 = M) - ( 2번째 행에서 칠할 색깔의 수 )
			 * (3번째 행의 총 타일의 개수 = 열의 수 = M) - ( 3번째 행에서 칠할 색깔의 수 )
			 * ...
			 * (N번째 행의 총 타일의 개수 = 열의 수 = M) - ( N번째 행에서 칠할 색깔의 수 )
			 * 의 합이다.
			 *
			 * 따라서, (흰색을 i줄만큼, 파랑 줄을 j-i줄만큼 선택했을 때, 칠해야 하는 타일 수) = spaceToPaint
			 * (그 이후 빨강 줄을 k-j줄만큼 선택했을 때, 칠해야 하는 타일 수) = tmpSpaceToPaint;
			 * spaceToPaint값이 오염되지 않도록 임시 저장할 변수 : tmp
			 */
			
			// 흰색 줄 칠하기
			for (int i = 1; i <= N-2; i++) {
				
				// 흰색 줄을 i만큼 칠한다, 칠해야 하는 타일 수는 spaceToPaint에 임시 저장
				spaceToPaint += (M-white[i]);
				
				// 파랑 줄을 칠하기 전 , tmp를 일단 spaceToPaint값으로 초기화
				int tmp = spaceToPaint;
				
				// 파랑 줄 칠하기
				for (int j = i+1; j <= N-1; j++) {
					
					// 파랑 줄을 한 줄씩 칠하고 최소값 비교 진행
					spaceToPaint += (M-blue[j]);
					int tmpSpaceToPaint = spaceToPaint; 
					
					// 빨강 줄 칠하기
					// 빨강 줄을 칠하고 난 후 전체 타일 수 : tmpSpaceToPaint
					for (int k = j+1; k <= N; k++) {
						tmpSpaceToPaint += (M-red[k]);
					}
					
					// tmpSpaceToPaint가 최소인지 비교
					if (tmpSpaceToPaint < minimumSpace) {
						minimumSpace = tmpSpaceToPaint;
					}
					
				}
				// spaceToPaint값 회복
				spaceToPaint = tmp;
			}
			// 결과 출력
			System.out.println("#"+(tc+1)+" "+minimumSpace);
		}
	}
}