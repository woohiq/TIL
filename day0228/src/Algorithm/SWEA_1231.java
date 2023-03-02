package Algorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1231 {
	
	// 이진 트리에 들어갈 노드 클래스
	public static class Node {
		char data;
		int left;
		int right;
		// 생성자
		public Node(char data, int left, int right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	// 이진 트리 클래스
	public static class BinaryTree {
		Node root;
		// 생성자
		public BinaryTree(int i) {
			this.root = nodes[i];
		}
	}
	
	// 중위순회를 하는 inorderTraverse 메서드
	public static void inorderTraverse(Node node) {
		if (node == null) return;
		else {
			inorderTraverse(nodes[node.left]);
			sb.append(node.data);
			inorderTraverse(nodes[node.right]);
		}
	}
	
	// 다른 메서드와 클래스에서 사용하기 위해, node들의 집합과 스트링 버퍼를 static으로 선언
	public static Node[] nodes;
	public static StringBuffer sb;
	
	public static void main(String[] args) {
		// 스캐너와 스트링 버퍼 선언
		Scanner sc = new Scanner(System.in);
		sb = new StringBuffer();
		for (int tc = 0; tc<10; tc++) {
			
			// 테스트 케이스를 스트링버퍼에 입력
			sb.append("#"+(tc+1)+" ");
			
			// N : 총 노드의 개수
			int N = sc.nextInt();
			sc.nextLine();
			
			nodes = new Node[N+1];
			
			// 각 노드들을 생성함
			// 바로 tree를 만들 수 없으므로 (지금 노드를 생성중임...)
			// nodes라는 노드의 배열에 저장해놓음
			for (int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				int nodeLeft = 0;
				int nodeRight = 0;
				int nodeIndex = Integer.parseInt(st.nextToken());
				char nodeData = st.nextToken().charAt(0);
				// 자식이 있는지 여부는 stringTokenizer의 hasMoreToken을 사용
				if (st.hasMoreTokens()) nodeLeft = Integer.parseInt(st.nextToken());
				if (st.hasMoreTokens()) nodeRight = Integer.parseInt(st.nextToken());
				
				Node newNode = new Node(nodeData, nodeLeft, nodeRight);
				nodes[nodeIndex] = newNode;
			}
			
			// 이진 트리를 생성함. root는 nodes 배열의 1번째인덱스
			BinaryTree bt = new BinaryTree(1);
			// 중위순회
			inorderTraverse(bt.root);
			// 결과출력
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
