package test01;

public class LinkedQueue {
	public Node head;
	public Node rear;
	
	public void enQueue(int data) {
		// 새로운 노드를 생성
		Node n = new Node(data);
		
		// 리스트가 비어있는지 여부 먼저 체크
		if(head == null) { // 리스트가 비어있다면
			head = n;
			rear = n;
		} else {
			rear.next = n;
			rear = rear.next;
		}
	}
	
	public int deQueue() {
		if(head != null) { // 리스트가 비어 있지 않다면
			Node toDelete = head; // 첫번째 노드 임시 저장
			head = head.next; // head가 그 다음 노드를 가리키도록 함
			return toDelete.data;
		}
		return -1;
	}
}
