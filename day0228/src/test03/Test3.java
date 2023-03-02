package test03;

public class Test3 {
	static char[] arr;
	static int N;
	
	public static void main(String[] args) {
		arr = new char[] {'\u0000','A','B','C','D','E','F','G','H','I','J','\u0000','\u0000','K','L','M'};
	
		N = arr.length;
		
		traverse(1);
	
	}
	
	public static void traverse(int i) {
		if(i>=N || arr[i] == '\u0000') return;
		else {
			traverse(i*2);
			traverse(i*2+1);
			System.out.println(arr[i]);
		}
	}
}
