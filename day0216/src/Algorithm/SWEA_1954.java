package Algorithm;

import java.util.Scanner;

public class SWEA_1954 {
	
	public static int size;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * ���ڰ� ������ �� ���·� ��ġ�Ǿ�� �ϹǷ� cnt�� �����ϸ鼭 �lġ�� �� ��� �������� �� ���� �Ǻ�
		 * �̵��� �켱������ ������ - �Ʒ� - ���� - ���� ��
		 * �������� üũ 
		 * ( �ٵ� ������ �迭�� ���ڰ� ä�����鼭 0���� ���θ� üũ�ϸ�� )
		 */
		// �켱���� : ������, �Ʒ�, ����, ��
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		// �׽�Ʈ ���̽� ���� �޾� �׸�ŭ �ݺ�
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			
			// �迭�� ũ�⸦ �Է¹ް� �ش� ũ���� �迭 �����
			size = sc.nextInt();
			int[][] grid = new int[size][size];
			
			// �迭�� ������ ���ڰ��� ������ ���� cnt
			int cnt = 0;
			
			// �迭�� ������ ��ǥ������ ����� currentX, currentY
			// currentX : ���� X��ǥ ( �迭�� ù ��° ���� )
			// currentY : ���� Y��ǥ ( �迭�� �� ��° ���� )
			int currentX = 0;
			int currentY = 0;
			
			// ù ��ǥ(0,0) �� ���� �ۼ��ϰ� ����
			grid[currentX][currentY] = ++cnt;
			
			here : while(true) {
				
				// �̵��� �� �ִ� ���� �ִٸ�
				// ��� �� �������� �̵�
				// �̵��� ���� ������ �ٽ� �̵� ���� �Ǻ�
				for (int i = 0; i<4; i++) {
					if (borderCheck(currentX+dx[i], currentY+dy[i]) && grid[currentX+dx[i]][currentY+dy[i]] == 0) {
						while(borderCheck(currentX+dx[i], currentY+dy[i]) && grid[currentX+dx[i]][currentY+dy[i]] == 0) {
							grid[currentX+dx[i]][currentY+dy[i]] = ++cnt;
							currentX += dx[i];
							currentY += dy[i];
						}
						continue here;
					}
					// �ƹ� ���� �� �� ���� ��� ������ ��������
				} break;
			}
			
			// ��� ���
			System.out.println("#"+(tc+1));
			for (int i = 0; i<size; i++) {
				for (int j = 0; j<size; j++) {
					System.out.print(grid[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	// �迭�� ��(��谪)�� �Ѿ���� Ȯ���ϴ� �޼��� 
	public static boolean borderCheck(int x, int y) {
		return (x>=0 && y>=0 && x<size && y<size);
	}
}
