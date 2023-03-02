package test03;

public class Test1 {
	public static void main(String[] args) {
		int[] A = {4, 9, 11, 23, 2, 19, 7};
		System.out.println(sequentialSearch(A,23));
		System.out.println(sequentialSearch(A,22));
		System.out.println(sequentialSearch(A,19));
	}
	public static int sequentialSearch(int[] A, int key) {
		for (int i = 0; i<A.length; i++) {
			if (A[i] == key) return i;
		}
		return -1;
	}
}
