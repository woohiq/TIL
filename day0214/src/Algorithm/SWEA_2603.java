package Algorithm;

import java.util.Scanner;

public class SWEA_2603 {
	public static void main(String[] args) {
		// 스캐너 선언
		Scanner sc = new Scanner(System.in);
		
		// 입력받을 정수 개수 N 과 그 입력을 받을 배열 Arr
		int N = sc.nextInt();
		int[] Arr = new int[N];
		
		// 배열에 값 저장
		for (int i = 0; i<N; i++) {
			Arr[i] = sc.nextInt();
		}
		
		// BubbleSort 로 오름차순 정렬
		for (int i = 0; i<N; i++) {
			for (int j = i; j<N; j++) {
				if (Arr[i] > Arr[j]) {
					int tmp = Arr[j];
					Arr[j] = Arr[i];
					Arr[i] = tmp;
				}
			}
		}
		
		// 중앙값 : N/2
		int middle = N/2;
		
		// 중앙값 출력
		System.out.println(Arr[middle]);
	}
}
