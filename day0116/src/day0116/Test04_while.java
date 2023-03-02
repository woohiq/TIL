package day0116;

import java.util.Scanner;

public class Test04_while {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		while(num == 1) {
			System.out.println("run");
			num = sc.nextInt();
		}
	}
}
