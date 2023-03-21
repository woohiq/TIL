package day0321;

import java.util.Arrays;

public class 조합_2 {
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
		for (int i = idx; i<=N-R+sidx; i++) {
			sel[sidx] = 토핑[i];
			combination(i+1, sidx+1);
		}
	}
}
