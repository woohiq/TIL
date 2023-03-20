package 제2회자바비전공자반알고리즘경진대회;

import java.util.Arrays;
import java.util.Scanner;

public class 보물상자비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc<=testCase; tc++) {
			// N : 전체숫자개수
			// N/4 : 만들어야 하는 수의 길이
			// K : k번째 큰 수 찾기
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			char[] input = sc.nextLine().toCharArray();
			
			// 만들 수 있는 총 수는
			// N/4 길이의 숫자를 4개씩 N/4번
			// N개만큼 만들수있음
			int[] numbers = new int[N];
			int cnt = 0;
			
			// 첫번째 변에 있는 숫자들의 인덱스 : 0, 1, 2, ... (N/4-1)
			// 두번째 변에 있는 숫자들의 인덱스 : N/4, N/4+1, N/4+2, ... (N/2-1)
			// ...
			// 이므로 각 변의 숫자는 N/4 * i 번째이상 N/4*(i+1) 미만까지
			
			// 이걸 j가 돌 수 있도록 한다.
			
			// 만약 상자를 회전시킨다면, 이 인덱스가 k (0이상  N/4미만) 만큼 밀리게 되고
			// 인덱스를 넘어가지 않도록 mod연산까지 해서 인덱스는 (j+k)%4
			for (int k = 0; k<N/4; k++) {
				for (int i = 0; i<4; i++) {
					int tmp = 0;
					for (int j = N/4*i; j<N/4*(i+1); j++) {
						tmp *= 16;
						if (input[(j+k)%N] >= '0' && input[(j+k)%N] <= '9') {
							tmp += (input[(j+k)%N] - '0');
						} else {
							tmp += (input[(j+k)%N] - 'A' + 10);
						}
					}
					numbers[cnt++] = tmp;
				}
			}
			Arrays.sort(numbers);
			
			// 정렬해서 이전 숫자와 같으면 중복된 숫자이므로 K번째 큰 수 계산에서 제외
			// K번째 큰 수 찾기
			int before = -1;
			for (int i = N-1; i>=0; i--) {
				if (numbers[i] == before) continue;
				else {
					K--;
					before = numbers[i];
				}
				if (K == 0) {
					System.out.println("#"+(tc)+" "+numbers[i]);
					break;
				}
			}
		}
	}
}
