package test02;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		int[] arr = {5, 2, 4, 1, 2, 3, 3};
		
		int[] count = new int[6]; 
		
		for (int i = 0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		
		for (int i = 1; i<count.length; i++) {
			count[i] += count[i-1];
		}
		
//		System.out.println(Arrays.toString(count));
		
		int[] sorted = new int[7];
		
		for (int i = arr.length-1; i>=0; i--) {
			sorted[--count[arr[i]]] = arr[i];
		}
		System.out.println(Arrays.toString(sorted));
	}
}
