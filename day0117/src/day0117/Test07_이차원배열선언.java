package day0117;

public class Test07_이차원배열선언 {
	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		int[] arr2[] = new int[3][4];
		
		for (int r = 0; r<3; r++) {
			for (int c = 0; c<4; c++) {
				System.out.printf("%4d",arr[r][c]);
			}
			System.out.println();
		}
	}
}
