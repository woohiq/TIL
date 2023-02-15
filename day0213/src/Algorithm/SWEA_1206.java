package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1206 {
	public static void main(String[] args) throws Exception {
		
		// 입출력 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// testcase : 10회
		for (int i = 0; i<10; i++) {
			
			// N : 각 테스트케이스당 받을 입력의 갯수
			// buildings : N만큼의 원소를 저장할수 있는 배열, 빌딩의 높이 정보를 담고 있음
			// cnt : 정답을 출력하기 위한 변수
			int N = Integer.parseInt(br.readLine());
			int[] buildings = new int[N];
			int cnt = 0;
			
			// buildings 배열에 정수 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j<N; j++) {
				buildings[j] = Integer.parseInt(st.nextToken());
			}
			
			// 양 끝단 두 자리는 0이므로 j는 2부터 N-2까지만 확인
			// 인접한 4개와의 크기비교
			// (자신의 크기) (인접한 4개중 가장 높은 수의 크기) 를 비교
			// 자신이 가장 크다면 그 차이를 cnt에 추가
			for (int j = 2; j<N-2; j++) {
				int max = Math.max(buildings[j-2], buildings[j-1]);
				max = Math.max(max, buildings[j+1]);
				max = Math.max(max, buildings[j+2]);
				if (buildings[j] > max) cnt += buildings[j]-max;
			}
			// 결과 출력
			bw.append("#"+(i+1)+" "+cnt+"\n");
		}
		bw.flush();
	}
}
