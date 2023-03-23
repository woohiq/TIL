package day0323_백트래킹;

import java.util.Scanner;

public class SWEA_6808_규영이와인영이의카드게임 {
	static int win,lose;
	static int[] gyu, inn;
	static boolean[] used;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for (int tc = 1; tc<=testCase; tc++) {
			win = 0;
			lose = 0;
			gyu = new int[10];
			used = new boolean[19];
			inn = new int[10];
			
			for (int i = 1; i<=9; i++) {
				int tmp = sc.nextInt();
				gyu[i] = tmp;
				used[tmp] = true;
			}
			int cnt = 0;
			for (int i = 1; i<=18; i++) {
				if (!used[i]) inn[cnt++] = i;
			}
			fight(0);
			System.out.println("#"+tc+" "+win+" "+lose);
		}
	}
	public static void fight (int cardcnt) {
		if (cardcnt == 9) {
			int gyuscore = 0;
			int innscore = 0;
			for (int i = 1; i<=9; i++) {
				if (gyu[i] > inn[i]) gyuscore += gyu[i]+inn[i];
				else innscore += gyu[i]+inn[i];
			}
			if (gyuscore > innscore) win++;
			else if (gyuscore < innscore) lose++;
			return;
		} 
		for (int i = 1; i<19; i++) {
			
			fight()
		}
	}
	
}
