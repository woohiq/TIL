package Algorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1232 {
	
	/**************************************************
	 * 노드에 들어올 수 있는 숫자의 입력의 범위에 제한이 없다..
	 * int형이라고 생각하고 일단 int로 받자
	 * 
	 * 중간 계산값의 범위에 대한 정보도 없다..
	 * 만약 10만 * 10만 같은 계산이 있으면 어떡하지?
	 * 일단 int범위 내에서 해결 된다고 믿고 int로 선언하고
	 * 오류가 발생하면 long으로 선언하거나 더 큰 값으로 선언하자
	 *************************************************/
	
	// nodes에는 각 노드들의 정보가 들어간다. 후위순회 메서드를 쓰기 위해 전역으로 선언
	public static int[][] nodes;
	
	// 후위순회 메서드
	public static int postOrderTraverse(int root) {
		
		// 만약 자신의 자식 노드가 없다면, 해당 노드는 숫자 정보를 담고 있다
		if (nodes[root][1] == 0) return nodes[root][0];
		
		// 자식 노드가 있다면, 자식 노드들의 후위순회 메서드의 결과는 중간계산값 또는 숫자 정보를 담고 있다
		// 또한 해당 노드는 연산자 정보를 담고 있다
		int left = postOrderTraverse(nodes[root][1]);
		int right = postOrderTraverse(nodes[root][2]);
		
		// 연산자 정보는 다음과 같다
		// 10억 : 덧셈연산
		// 10억1 : 뺄셈연산
		// 10억2 : 곱셈연산
		// 10억3 : 나눗셈연산
		if (nodes[root][0] == 1000000000) return left+right;
		else if (nodes[root][0] == 1000000001) return left-right;
		else if (nodes[root][0] == 1000000002) return left*right;
		else if (nodes[root][0] == 1000000003) return left/right;
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		// 스캐너와 스트링버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		// 테스트케이스 : 10회, 그만큼 반복
		int testCase = 10;
		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#"+tc+" ");
			int N = sc.nextInt();
			sc.nextLine();
			
			// 노드의 정보가 들어가는 nodes 배열
			// 각각의 원소는 다음과 같다
			// nodes[i][0] : i번째 node에 들어가 있는 숫자 or 연산자 정보
			// nodes[i][1] : i번째 node의 왼쪽 자식의 인덱스
			// nodes[i][2] : i번째 node의 오른쪽 자식의 인덱스
			nodes = new int[N+1][3];
			
			for (int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				
				// 자신 노드의 번호 : node
				int node = Integer.parseInt(st.nextToken());
				
				// 숫자 또는 연산자 정보를 str에 저장함
				String str = st.nextToken();
				int tmp;
				
				// 만약 연산자 정보라면, 덧셈 : 10억, 뺄셈 : 10억1, ...
				// (char형으로 따로 선언해 줄까 하다가 이미 배열을 int형으로 만들었으므로...)
				// (중간 연산값이 10억을 넘지 않길 바라며 10억으로 선언해보자)
				if (str.equals("+")) tmp = 1000000000;
				else if (str.equals("-")) tmp = 1000000001;
				else if (str.equals("*")) tmp = 1000000002;
				else if (str.equals("/")) tmp = 1000000003;
				
				// 연산자 정보가 아니라면 숫자를 저
				else tmp = Integer.parseInt(str);
				
				// 만약 뒤에 추가적인 입력이 있으면 그건 자식에 대한 정보
				if (st.hasMoreTokens()) {
					int left = Integer.parseInt(st.nextToken());
					int right = Integer.parseInt(st.nextToken());
					nodes[node][1] = left;
					nodes[node][2] = right;
				}
				nodes[node][0] = tmp;
			}
			
			// 후위순회를 하며 계산후 결과출력
			int answer = postOrderTraverse(1);
			sb.append(answer+"\n");
		}
		System.out.println(sb);
	}
}
