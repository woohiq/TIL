package day0322;

import java.util.Arrays;

public class MergeSort {
	static int[] sortedArr;
	public static void main(String[] args) {
		int[] Arr = new int[] {14, 1, 5, 16, 2, 13, 3, 17, 15, 7, 8, 19, 9, 18, 4, 10, 20, 6, 11, 12};
		sortedArr = new int[Arr.length];
		mergeSort(Arr, 0, Arr.length-1);
		
		System.out.println(Arrays.toString(Arr));
		System.out.println(Arrays.toString(sortedArr));
	}

	private static void mergeSort(int[] arr, int left, int right) {
		
		if (left >= right) return;
		
		int middle = (left + right)/2;
		
		mergeSort(arr, left, middle);
		mergeSort(arr, middle+1, right);
		merge(arr, left, middle, right);
		
	}

	private static void merge(int[] arr, int start, int middle, int end) {
		int left = start;
		int right = middle+1;
		int index = start;
		
		while(left <= middle && right <= end) {
			if (arr[left] < arr[right]) sortedArr[index++] = arr[left++];
			else sortedArr[index++] = arr[right++];
		}
		
		if (left <= middle) {
			while(left <= middle) {
				sortedArr[index++] = arr[left++];
			}
		}
		else {
			while(right <= end) {
				sortedArr[index++] = arr[right++];
			}
		}
		
		for (int i = start; i <= end; i++) {
			arr[i] = sortedArr[i];
		}
	}
	
}
