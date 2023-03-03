import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		here: for (int tc = 0; tc<testCase; tc++) {
			int N = sc.nextInt();
			
			int[] trees = new int[N];
			
			for (int i = 0; i<N; i++) {
				trees[i] = sc.nextInt();
			}
			
			int max = 0;
			for (int i = 0 ; i<N; i++) {
				if (trees[i] > max) max = trees[i];
			}
			
			int one = 0;
			int two = 0;
			
			for (int i = 0; i<N; i++) {
				int tmp = max - trees[i];
				two += tmp / 2;
				one += tmp % 2;
			}
			if (one == two) {
				System.out.println("#"+(tc+1)+" "+(one+two));
				continue here;
			} else if (one > two) {
				System.out.println("#"+(tc+1)+" "+(one*2-1));
				continue here;
			}
			while(one < two) {
				two--;
				one+=2;
			}
			System.out.println("#"+(tc+1)+" "+(one+two));
		}
	}
}
