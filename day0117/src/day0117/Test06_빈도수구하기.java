package day0117;

import java.util.Arrays;

public class Test06_빈도수구하기 {
	public static void main(String[] args) {
		// 0~9숫자 배열
		int[] arr = new int[] {0, 0, 2, 1, 3, 0, 6, 2, 5, 7, 8, 2, 5, 3};
		//카운팅 배열
		int[] count = new int[10]; // index = 해당 숫자
		//count[num] 빈도수
		//count[index] index=num인 숫자의 빈도수
		for(int i = 0; i<arr.length; i++) count[arr[i]]++;
		System.out.println(Arrays.toString(count));
	}
}
