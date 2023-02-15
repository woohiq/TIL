package test02;

import java.util.Arrays;

public class Test1 {
	/*
	 * Selection Sort
	 * 주어진 배열
	 * 원소의 개수
	 * 
	 * 전체 배열 원소 : 0 ~ n-1
	 * 그래서 비교는 0 ~ n-1번째 인덱스에서
	 * 
	 * 최소 찾고, 맨 앞으로
	 * 
	 * 그렇게 0 ~ n-2까지 반복 ( 마지막 한 번은 안해도 된다 ! )
	 * 
	 * i -> 0~n-2
	 * idx = i
	 * j = i+1~n-1
	 * j값이 i값보다 작다면 최소값에 할당
	 * 
	 */
	
	public static void main(String[] args) {
		int[] A = {5, 4, 3, 2, 1};
		
		int n = A.length;
		
		for (int i = 0; i<n-1; i++) {
			int minIdx = i;
			for (int j = i+1; j<n; j++) {
				if (A[j] < A[minIdx]) {
					minIdx = j;
				}
			}
			int tmp = A[minIdx];
			A[minIdx] = A[i];
			A[i] = tmp;
		}
		
		for (int ele : A) {
			System.out.println(ele);
		}
		
		System.out.println(Arrays.toString(A));
	}
}
