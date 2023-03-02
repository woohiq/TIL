package test02;

public class Test1 {
	public static void main(String[] args) {
		int a = 1;
		int b = 3;
		
		for (int i = a; i<=b; i++) {
			for (int j = a; j<=b; j++) {
				if (i == j) continue;
				for (int k = a; k<=b; k++) {
					if (k == i || k == j) continue;
					System.out.printf("%d %d %d\n", i, j, k);
				}
			}
		}
	}
}
