package test02;

public class Test3 {

	public static void main(String[] args) {
		// 800��
				// 400�� * 2��
				
				// 600��
				// 300�� * 2��, 500�� 1�� 100�� 1��
				
				// 580��
				// 290�� * 2��, 500�� 1�� 50�� ...
				
				// 510��
				// 255��
				
				// 500��
				// 250�� 
				
				int money = 800;
				
				int c500 = money / 500;
				money -= c500 * 500;
				
				int c400 = money / 400;
				money -= c400 * 400;
				
				int c100 = money / 100;
				money -= c100 * 100;
				
				int c50 = money / 50;
				money -= c50 * 50;
				
				int c10 = money / 10;
				money -= c10 * 10;
				
				System.out.printf("500��: %d\n", c500);
				System.out.printf("400��: %d\n", c400);
				System.out.printf("100��: %d\n", c100);
				System.out.printf(" 50��: %d\n", c50);
				System.out.printf(" 10��: %d\n", c10);
	}
}
