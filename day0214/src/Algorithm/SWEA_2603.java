package Algorithm;

import java.util.Scanner;

public class SWEA_2603 {
	public static void main(String[] args) {
		// ��ĳ�� ����
		Scanner sc = new Scanner(System.in);
		
		// �Է¹��� ���� ���� N �� �� �Է��� ���� �迭 Arr
		int N = sc.nextInt();
		int[] Arr = new int[N];
		
		// �迭�� �� ����
		for (int i = 0; i<N; i++) {
			Arr[i] = sc.nextInt();
		}
		
		// BubbleSort �� �������� ����
		for (int i = 0; i<N; i++) {
			for (int j = i; j<N; j++) {
				if (Arr[i] > Arr[j]) {
					int tmp = Arr[j];
					Arr[j] = Arr[i];
					Arr[i] = tmp;
				}
			}
		}
		
		// �߾Ӱ� : N/2
		int middle = N/2;
		
		// �߾Ӱ� ���
		System.out.println(Arr[middle]);
	}
}
