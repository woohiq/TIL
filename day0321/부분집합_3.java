package day0321;

public class 부분집합_3 {
	static String[] 재료 = {"참치", "우엉", "삼겹살"};
	static int N;
	static boolean[] sel;
	public static void main(String[] args) {
		N = 3;
		sel = new boolean[N];
		
		powerset(0);
	}
	public static void powerset(int idx) {
		if (idx >= N) {
			for (int i = 0; i<N; i++) {
				if (sel[i]) System.out.print(재료[i]);
			}
			System.out.println();
			return;
		}
		sel[idx] = false;
		powerset(idx+1);
		sel[idx] = true;
		powerset(idx+1);
	}
}	
