package day0321;

import java.util.Arrays;

public class 부분집합_1 {
	public static void main(String[] args) {
		int N = 3;
		int[] sel = new int[N];
		
		for (int i = 0; i<2; i++) {
			sel[0] = i;
			for (int j = 0; j<2; j++) {
				sel[1] = j;
				for (int k = 0; k<2; k++) {
					sel[2] = k;
					
					System.out.println(Arrays.toString(sel));
				}
			}
		}
	}
}	
