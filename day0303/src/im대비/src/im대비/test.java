package im대비;

import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
	public static void main(String[] args) {
		String str = "1 4 4 3 4 5 3 3 4 5 5 5 4 5 6 3 5 3 3 5 5 3 5 6 5 1 2 5 2 4 3 3 6 3 4 1 4 6 3 3 4 6 3 4 5 5 5 5 5 4 6 6 3 3 4 1 5 3 5 1 5 5 5 5 1 5 5 5 5 2 3 2 4 5 6 3 2 5 3 3 5 5 1 5 5 4 6 1 6 4 5 5 1 2 1 6 5 6 5 5";
		StringTokenizer st = new StringTokenizer(str);
		
		int[] test = new int[7];
		for (int i = 0; i<100; i++) {
			int in = Integer.parseInt(st.nextToken());
			test[in]++;
		}
		System.out.println(Arrays.toString(test));
	}
}
