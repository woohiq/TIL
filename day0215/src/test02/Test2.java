package test02;

public class Test2 {
	public static void main(String[] args) {
		// 배열의 숫자 중에서
		// 3개를 뽑아 나열
		
		int[] arr = {2, 5, 8, 9};
		
		for (int i = 0; i<arr.length; i++) {
			for (int j = 0; j<arr.length; j++) {
				if (i == j) continue;
				for (int k = 0; k<arr.length; k++) {
					if (k == i || k == j) continue;
					System.out.printf("%d %d %d\n",arr[i] , arr[j], arr[k]);
				}
			}
		}
	}
}
