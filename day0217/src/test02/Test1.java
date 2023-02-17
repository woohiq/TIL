package test02;

public class Test1 {
	public static void main(String[] args) {
		char[] t = "This iss a book".toCharArray();
		
		char[] p = "iss".toCharArray();
		
		int idx = BruteForceFor(p,t);
		System.out.println(idx);
		
		idx = BruteForceWhile(p,t);
		System.out.println(idx);
	}

	private static int BruteForceWhile(char[] p, char[] t) {
		int i = 0;
		int j = 0;
		while(i < p.length && j < t.length) {
			if (p[i] != t[j]) {
				j = j - i;
				i = -1;
			}
			i++;
			j++;
		}
		if (i == p.length) return j-i;
		else return -1;
	}

	private static int BruteForceFor(char[] p, char[] t) {
		here: for (int i = 0; i<t.length-p.length+1; i++) {
			for (int j = 0; j<p.length; j++) {
				if (p[j] != t[i+j]) continue here;
			}
			return i;
		}
		return -1;
	}
	
	
}
