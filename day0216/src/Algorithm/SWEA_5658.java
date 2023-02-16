package Algorithm;

import java.util.Scanner;

public class SWEA_5658 {
	public static void main(String[] args) {
		
		// ��ĳ�ʸ� �̿��� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		
		// �׽�Ʈ���̽� ���� �Է¹ް� �ش� ����ŭ �ݺ�
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// N : ���� �Է��� ����
			// K : ã�� ū���� �ε��� ( K��° ū �� )
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			/*
			 * �Է��� ���� �迭 numbers
			 * �Է����� ���� �� �ִ� 16���� ���ڵ��� ������ combinations
			 * 
			 * �Է��� ���� �迭 number�� ũ�⸦ 
			 * N�� �ƴ϶� N+N/4�� �����ϸ�
			 * �ܼ��� �ε����� �ϳ� �̷�� ������
			 * ���������� �Ѳ��� ���ư��� ������ �� �ִ�
			 */
			int[] numbers = new int[N+N/4];
			int[] combinations = new int[N];
			
			String input = sc.nextLine(); 
			
			// �Է��� ���ڿ��� �޾� �ش� �ε����� �ִ� Character�� �̿��� ���ڷ� ��ȯ
			// (����) => �״��, A => 10, B => 11 ... �̷���
			for (int i = 0; i<N+N/4; i++) {
				int tmp = input.charAt(i%N);
				
				if (tmp >= (int)'A' && tmp <= (int)'F') tmp -= ((int)'A'-10);
				else tmp = Integer.valueOf(tmp) - '0';
				
				numbers[i] = tmp;
			}
			
			// combination�� ������ index ����
			int cnt = 0;
			
			/*
			 * �������� �Ѳ��� ���ư� �� �������� �Ѳ��� ���ڵ��� �̿��� 16���� ���� ������
			 * 
			 * �������� �Ѳ��� ���ư� Ƚ�� : iȸ
			 * �������� �Ѳ��� �� N/4����ŭ ���ư��� �ִ�
			 * 
			 * ���������� ���� �ε��� : j
			 * ���������� ���� �� 4�� �ִ�
			 * 
			 * �������� �� �鿡 �����ϴ� ���ڵ��� �ε��� : k
			 * �������� �� �鿡�� �� N/4���� ���ڵ��� �����Ѵ�
			 * 
			 * ����, �ش��ϴ� �鿡�� ���� �� �ִ� 16���� ����
			 * numbers[ i + (N/4)*j + N/4-1 ] * 16^0 +
			 * numbers[ i + (N/4)*j + N/4-2 ] * 16^1 +
			 * numbers[ i + (N/4)*j + N/4-3 ] * 16^2 +
			 * ... +
			 * numbers[ i + (N/4)*j + 0 ] * 16^(N/4-1)
			 * 
			 * k�� 0���� N/4-1���� 
			 * ��, numbers[i+N/4*j+k]*Math.pow(16, N/4-k-1); �� ��
			 */
			for (int i = 0; i<N/4; i++) {
				for (int j = 0; j<4; j++) {
					int tmp = 0;
					for (int k = 0; k<N/4; k++) {
						tmp += numbers[i+N/4*j+k]*Math.pow(16, N/4-k-1);
					}
					// �̸� ���տ� ����
					combinations[cnt++] = tmp;
				}
			}
			
			/*
			 * ���ڵ��� ������ ������ ���� �������� �����Ѵ�
			 * (�⺻������ BubbleSort)
			 * 
			 * ���� ���� ���ں��� ������ ���ڰ� �� ũ�ٸ� SWAP
			 * 
			 * ���� ���� ���ڿ� ������ ���ڰ� ���ٸ� ������ ���ڸ� 0���� ����
			 * ( ������ ������ ���� �� �۾ƾ� �ϹǷ� ������������ �������� ) 
			 */
			for (int i = 0; i<combinations.length; i++) {
				for (int j = i+1; j<combinations.length; j++) {
					if (combinations[j] > combinations[i]) {
						int tmp = combinations[j];
						combinations[j] = combinations[i];
						combinations[i] = tmp;
					} else if (combinations[j] == combinations[i]) {
						combinations[j] = 0;
					}
				}
			}
			
			// ��� ���
			System.out.println("#"+(tc+1)+" "+combinations[K-1]);
			
		}
		
	}
}
