package Algorithm;

import java.util.Scanner;

public class SWEA_1248 {
	
	// 몇 가지 변수들을 전역으로 설정
	// subtree의 크기를 셀 cnt변수 ( travarse 메서드를 쓰면서 세기 위해 )
	// 자식 노드의 정보를 담고 있는 childs 배열 ( 역시 travarse 메서드를 쓰기 위해 ) 
	public static int cnt;
	public static int[][] childs;
	
	// subtree의 크기를 세기 위해서 사용한 전위탐색 메서드
	// 자신을 방문하는것을 cnt를 늘리는 것으로 한다면,
	// (메서드가 전부 끝난 후 최종적인 cnt의 수) = (방문한 노드의 수) 이므로
	// 방문한 노드의 수를 알 수 있다!
	public static void preorderTravarse(int root) {
		int left = childs[root][0];
		int right = childs[root][1];
		if (left != 0) preorderTravarse(left);
		cnt++;
		if (right != 0) preorderTravarse(right);
		
	}
	
	public static void main(String[] args) {
		
		// 스캐너와 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		// 테스트 케이스 개수 입력받고 스트링버퍼에 테스트케이스 기입
		int testCase = sc.nextInt();
		for (int tc = 0; tc<testCase; tc++) {
			sb.append("#"+(tc+1)+" ");
			
			// 정점의 개수 vertexNum
			// 간선의 개수 edgeNum
			// 공통조상을 찾기 원하는 두 노드 targetX, targetY
			int vertexNum = sc.nextInt();
			int edgeNum = sc.nextInt();
			int targetX = sc.nextInt();
			int targetY = sc.nextInt();
			
			// parents : 각 노드의 부모의 정보를 담고 있는 배열
			// childs : 각 노드의 자식의 정보를 담고 있는 배열
			// childs 배열은 자식노드가 2개까지 가능하므로 2차원 배열로 선언 
			int[] parents = new int[vertexNum+1];
			childs = new int[vertexNum+1][2];
			
			// 각 간선에 대한 정보를 입력받음
			for (int i = 0; i<edgeNum; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				
				// 부모 설정
				parents[child] = parent;
				// 자식 설정
				if (childs[parent][0] == 0) {
					childs[parent][0] = child;
				} else {
					childs[parent][1] = child;
				}
			}
			
			// ( 찾으려는 노드 )는 
			// ( targetX와 targetY의 공통된 조상중 가장 depth가 깊은 조상 )이다
			
			// 그리고 조상이 같을 수 있는 후보는 서로 깊이가 같아야한다
			// 그래서 깊이가 같은 것들끼리 비교해나간다면 좀 더 빠르지않을까 ? (라고생각했는데아니었다)
			
			// targetX와 targetY의 깊이를 계산하기 위한 두 변수 target*depth
			int targetXdepth = 0;
			int targetYdepth = 0;
			
			// xtmp와 ytmp가 rootNode 쪽으로 이동하면서 targetX와 targetY의 깊이를 측정하고
			// 후에 같은 깊이를 맞추며 공통된 조상을 탐색할 것임
			int xtmp = targetX;
			int ytmp = targetY;
			
			// targetX와 targetY의 깊이 측정
			while(xtmp != 1) {
				xtmp = parents[xtmp];
				targetXdepth++;
			}
			while(ytmp != 1) {
				ytmp = parents[ytmp];
				targetYdepth++;
			}
			
			// 같은 깊이를 이동하며 공통된 조상을 찾기
			while(targetX != targetY) {
				if (targetXdepth > targetYdepth) {
					targetX = parents[targetX];
					targetXdepth--;
				} else if (targetXdepth < targetYdepth) {
					targetY = parents[targetY];
					targetYdepth--;
				} else {
					targetX = parents[targetX];
					targetY = parents[targetY];
				}
			}
			
			// 결과 출력
			sb.append(targetX+" ");
			
			// 탐색을 이용해 subtree의 크기를 계산하기
			preorderTravarse(targetX);
			sb.append(cnt+"\n");
			cnt = 0;
		}
		System.out.print(sb);
	}
}
