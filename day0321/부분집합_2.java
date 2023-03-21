package day0321;

public class 부분집합_2 {
	public static void main(String[] args) {
		int N = 3;
		int[] sel = new int[N];
		
		for (int i = 0; i<(1<<N); i++) {
			if ((i & 1) == 1) System.out.print("참치");
			if ((i & 2) == 2) System.out.print("우엉");
			if ((i & 4) == 4) System.out.print("삼겹살");
			System.out.println("김밥");
		}
	}
}	
