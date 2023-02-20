package Algorithm;

import java.util.Scanner;

public class SWEA_2007 {
	public static void main(String[] args) {
		/****************************************
		 * 개인적으로 문제가 좀 허점이 많고 이상한듯...
		 * KOREAKOREAKOREAKOREAKOREAKOREA의 경우 
		 * 마디길이는 5, 10, 20, 30 전부 가능한데
		 * '최소' 마디 길이를 구하라고 말을 해줬더라면...
		 ****************************************/
		
		// 스캐너 선언 및 결과를 출력할 StringBuffer 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 개수를 받아 그만큼 반복
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 0; tc<testCase; tc++) {
			// 문자열을 입력받음
			String str = sc.nextLine();
			sb.append("#"+(tc+1)+" ");
			
			// 문자열의 마디 길이 찾기
			// '최소' 마디길이를 찾아야함
			// 따라서 1부터 10까지 길이의 마디길이 중 최소를 찾자
			// 마디길이마다 모든 부분문자열이 동일해야함
			here : for (int i = 1; i<=10; i++) {
				for (int j = 1; i*(j+1)<=30; j++) {
					// 동일하지 않으면 다음 마디길이를 확인하도록 continue
					if (!str.substring((j-1)*i, j*i).equals(str.substring(j*i, (j+1)*i))) continue here;
				}
				// 동일하다면 결과 출력
				sb.append(i+"\n");
				break;
			}
		}
		// 전체 결과 출력
		System.out.print(sb);
	}
}
