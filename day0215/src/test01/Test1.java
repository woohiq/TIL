package test01;

public class Test1 {
	public static void main(String[] args) {
		int[] A = {2, 4, 7, 9, 11, 19, 23};
		System.out.println(binarySearch(A, 9));
		System.out.println(binarySearch(A, 18));
		System.out.println(binarySearch(A, 19));
	}
	
	public static boolean binarySearch(int[] A, int key) {
		int N = A.length;
		
		int start = 0;
		int end = N-1;
		
		while(start <= end) {
			int middle = (start+end)/2;
			if (A[middle] == key) return true;
			else if (A[middle] > key) end = middle - 1;
			else start = middle + 1;
		}
		
		return false;
	}
}
