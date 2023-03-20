import java.util.Scanner;
 
public class SWEA_10726_이진수표현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int tc = 1; tc<=testCase; tc++) {
        	/*
        	 *  숫자 M의 마지막 N개의 비트가 모두 1인지 검사
        	 *  (M) % (2^N) 이 (2^N-1) 이면 됨
        	 *  
        	 *  예를들어, 마지막 4비트가 모두 1인지 판별은
        	 *  XXXXXXXX1111 이어야 하므로 (X는 각 비트가 0또는 1이라는 뜻)
        	 *  000000010000 으로 나누었을때의 나머지가 1111이면됨
        	 */
        	// N과 M, 2^N 계산
            int N = sc.nextInt();
            int M = sc.nextInt();
            int tmp = (int) Math.pow(2, N);
            if ((M % tmp) == (tmp - 1)) {
                System.out.println("#"+tc+" ON");
            } else {
                System.out.println("#"+tc+" OFF");
            }
        }
    }
}