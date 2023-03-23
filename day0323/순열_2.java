package day0323_백트래킹;

import java.util.Arrays;

public class 순열_2 {
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		perm(0);
	}
	
	public static void perm(int idx) {
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		} 
		
		for (int i = idx; i<N; i++) {
			
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);
		}
	}
	
	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
