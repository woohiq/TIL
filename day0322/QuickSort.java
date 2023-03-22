package day0322;

import java.util.Arrays;

public class QuickSort {
	static int[] sortedArr;
	public static void main(String[] args) {
		int[] Arr = new int[] {14, 1, 5, 16, 2, 13, 3, 17, 15, 7, 8, 19, 9, 18, 4, 10, 20, 6, 11, 12};
		quickSort(Arr, 0, Arr.length-1);
		
		System.out.println(Arrays.toString(Arr));
	}
	
	
	
	private static void quickSort(int[] arr, int start, int end) {
		
		if (start >= end) return;
		
		int pivot = quickSortPartition(arr, start, end);
		
		quickSort(arr, start, pivot);
		quickSort(arr, pivot+1, end);
	}



	private static int quickSortPartition(int[] arr, int start, int end) {
		int pivot = arr[start];
		
		int left = start+1;
		int right = end;
		
		while(left <= right) {
			while(pivot < arr[right]) {
				right--;
			}
			
			// left <= right 조건을 검사해야함,
			// 그렇지 않다면, left가 계속 커져 인덱스를 벗어날수도
			
			// pivot 등호는 여기에 달려야함,
			// 그렇지 않다면, R이 줄어들어 -1 인덱스에 접근하는 경우도 발생할수도
			while(left <= right && pivot >= arr[left]) {
				left++;
			}
			
			// left < right인 경우에 대해서만 swap을 해야함,
			// 그렇지 않다면, left가 right보다 한순간 1 더 커질 때 swap이 되어버려 정렬이 되지 않음 
			if (left < right) swap(arr, left, right);
		}
		
		swap(arr, start, right);
		
		return right;
	}

	private static void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}
