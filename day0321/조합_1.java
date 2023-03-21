package day0321;

import java.util.Arrays;

public class 조합_1 {
	static String[] 토핑 = {"상추" , "패티" , "토마토" , "치즈"};
	
	static int N = 4;
	static int R = 2;
	
	static String[] sel = new String[R];
	
	public static void main(String[] args) {
		combination(0, 0);
	}
	public static void combination(int idx, int sidx) {
		
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (idx == N) {
			return;
		}
		
		combination(idx+1, sidx);
		sel[sidx] = 토핑[idx];
		combination(idx+1, sidx+1);
	}
}
