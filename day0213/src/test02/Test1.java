package test02;

import java.util.Arrays;

public class Test1 {
	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3, 4, 5, 6};
		
//		for (int i = 0; i<nums.length; i++) {
//			System.out.println(nums[i]);
//		}
//		
//		for (int num : nums) {
//			System.out.println(num);
//		}
		
//		for (int i = nums.length-1 ; i>=0 ; i--) {
//			System.out.println(nums[i]);
//		}
//		
//		int N = nums.length;
//		for (int i = 0; i<N; i++) {
//			System.out.println(nums[N-1-i]);
//		}
		
		int[] arr = {5, 4, 3, 2, 1};
		
		for (int i = 0; i<arr.length-1; i++) {
			for (int j = 0; j<arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		for (int in : arr) {
			System.out.println(in);
		}
	}
}
