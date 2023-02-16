package test01;

public class Test1_ArrayTest {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int n = arr.length;
		int m = arr[0].length;

		// 1. 행 우선 순회
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println();
		// 2. 행 역우선 순회
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println();
		// 3. 열 우선 순회
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println();
		// 4. 열 역우선 순회
		for (int j = 0; j < m; j++) {
			for (int i = n - 1; i >= 0; i--) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println();
		// 5-1. 지그재그 순회
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++) {
					System.out.printf("%3d", arr[i][j]);
				}
			} else {
				for (int j = m - 1; j >= 0; j--) {
					System.out.printf("%3d", arr[i][j]);
				}
			}
			System.out.println(" ");
		}
		System.out.println();
		// 5-2. 지그재그 순회
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < m; j++) {
					System.out.printf("%3d", arr[i][j]);
				}
			} else {
				for (int j = 0; j < m; j++) {
					System.out.printf("%3d", arr[i][m - 1 - j]);
				}
			}
			System.out.println(" ");
		}
		System.out.println();
		// 5-3. 지그재그 순회
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%3d", arr[i][j + (m - 1 - 2 * j) * (i % 2)]);
			}
			System.out.println(" ");
		}
		System.out.println();

	}
}
