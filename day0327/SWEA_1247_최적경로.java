import java.util.Scanner;

public class SWEA_1247_최적경로 {
	static int ans, N, homeX, homeY;
	static int[][] customer;
	static boolean[] takeCustomer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase= sc.nextInt();
		for (int tc = 1; tc<=testCase; tc++) {
			
			// N : 손님의 개수
			N = sc.nextInt();
			
			// 손님의 위치 정보를 저장하는 배열 customer
			customer = new int[N][2];
			
			// 시작위치 : company X, company Y
			// 종료위치 : home X  , company Y
			homeX = sc.nextInt();
			homeY = sc.nextInt();
			int companyX = sc.nextInt();
			int companyY = sc.nextInt();
			for (int i = 0; i<N; i++) {
				customer[i][0] = sc.nextInt();
				customer[i][1] = sc.nextInt();
			}
			
			// 각 손님을 방문했는지 여부를 나타내는 배열 takeCustomer
			takeCustomer = new boolean[N];
			ans = Integer.MAX_VALUE;
			
			// 재귀 시작하면서 최소 거리 탐색
			taxi(0, 0, companyX, companyY);
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void taxi(int cnt, int sum, int startX, int startY) {
		
		// 만약 중간 합계가 기존 최소값보다 크다면 탐색할 필요 없음
		// pruning
		if (sum >= ans) return;
		
		// 만약 모든 손님을 방문했다면 집으로 귀환
		// 그 떄까지의 거리가 최소라면 갱신
		if (cnt == N) {
			sum += Math.abs(startX - homeX) + Math.abs(startY - homeY);
			ans = (ans < sum) ? ans : sum;
			return;
		}
		
		// 만약 모든 손님을 방문하지 않았다면 손님들 방문
		for (int i = 0; i<N; i++) {
			if (takeCustomer[i]) continue;
			takeCustomer[i] = true;
			int distance = Math.abs(startX - customer[i][0]) + Math.abs(startY - customer[i][1]);
			taxi(cnt+1, sum + distance, customer[i][0], customer[i][1]);
			takeCustomer[i] = false;
		}
	}
}
