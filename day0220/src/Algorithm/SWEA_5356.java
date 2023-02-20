package Algorithm;

import java.util.Scanner;

public class SWEA_5356 {
	public static void main(String[] args) {
		
		// 스캐너 선언 후 testCase 개수 입력받고 그만큼 반복
		Scanner sc = new Scanner(System.in);
		
		// 결과를 출력하기 위한 StringBuffer 선언
		StringBuffer sb = new StringBuffer();
		
		// testCase 입력받고 반복
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 0; tc<testCase; tc++) {
			// stringBuffer에 testCase마다 앞에 붙는 거 미리 쓰기
			sb.append("#"+(tc+1)+" ");
			
			// 5개의 문자열을 받는다 ( char형 배열로 )
			// 각각 first, second ... fifth라고 하자
			char[] first, second, third, fourth, fifth;
			first = sc.nextLine().toCharArray();
			second = sc.nextLine().toCharArray();
			third = sc.nextLine().toCharArray();
			fourth = sc.nextLine().toCharArray();
			fifth = sc.nextLine().toCharArray();
			
			// 그 문자열의 길이 firLen, secLen ... fifLen
			int firLen, secLen, thiLen, fouLen, fifLen;
			firLen = first.length;
			secLen = second.length;
			thiLen = third.length;
			fouLen = fourth.length;
			fifLen = fifth.length;
			
			// 문자열의 길이 중 최대값 Maxlen
			int Maxlen = Math.max(firLen, secLen);
			Maxlen = Math.max(Maxlen, thiLen);
			Maxlen = Math.max(Maxlen, fouLen);
			Maxlen = Math.max(Maxlen, fifLen);
			
			// 가장 긴 문자열의 길이만큼 반복해서 다음을 실행
			// 인덱스를 1씩 늘려가면서, 해당 인덱스에서
			// 문자열의 길이가 초과되지 않아 출력할 수 있다면
			// 해당 인덱스 번호에 해당하는 문자를 출력
			for (int i = 0; i<Maxlen; i++) {
				if (i < firLen) sb.append(first[i]);
				if (i < secLen) sb.append(second[i]);
				if (i < thiLen) sb.append(third[i]);
				if (i < fouLen) sb.append(fourth[i]);
				if (i < fifLen) sb.append(fifth[i]);
				
			}
			// 개행문자 입력
			sb.append("\n");
		}
		// 결과출력
		System.out.print(sb);
	}
}
