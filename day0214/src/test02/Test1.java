package test02;

import java.util.Arrays;

public class Test1 {
	/*
	 * Selection Sort
	 * �־��� �迭
	 * ������ ����
	 * 
	 * ��ü �迭 ���� : 0 ~ n-1
	 * �׷��� �񱳴� 0 ~ n-1��° �ε�������
	 * 
	 * �ּ� ã��, �� ������
	 * 
	 * �׷��� 0 ~ n-2���� �ݺ� ( ������ �� ���� ���ص� �ȴ� ! )
	 * 
	 * i -> 0~n-2
	 * idx = i
	 * j = i+1~n-1
	 * j���� i������ �۴ٸ� �ּҰ��� �Ҵ�
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
