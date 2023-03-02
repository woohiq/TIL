package test02;

public class SinglyLinkedList {
	public Node head;
	
	public SinglyLinkedList() {}
	
	// 가장 마지막에 추가하는 addToEnd
	// 가장 처음에 추가하는 addToStart
	// 특정 값을 갖는 노드 다음에 addAfter
	// 특정 값을 갖는 노드를 반환 getNode
	// 가장 마지막 노드삭제 deleteLast
	// 가장 처음 노드삭제 deleteStart
	// 특정 값을 갖는 노드의 다음 노드 삭제 deleteAfter
	public void addToEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		} else {
			Node tmp = head;
			while(tmp.link != null) {
				tmp = tmp.link;
			}
			tmp.link = newNode;
		}
	}
	
	public void addToStart(int data) {
		Node newNode = new Node(data);
		newNode.link = head;
		head = newNode;
	}
	
	public Node getNode(int target) {
		Node tmp = head;
		while(tmp != null && tmp.data != target) {
			tmp = tmp.link;
		}
		if (tmp.data == target) return tmp;
		else return null;
	}
	
	public void addAfter(int target, int data) {
		Node targetNode = getNode(target);
		if (targetNode != null) {
			Node newNode = new Node(data);
			newNode.link = targetNode.link;
			targetNode.link = newNode;
		}
	}
	
	public void printList() {
		Node tmp = head;
		System.out.print("LinkedList : [ ");
		while(tmp != null) {
			System.out.print(tmp.data+" -> ");
			tmp = tmp.link;
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.addToEnd(2);
		ll.addToEnd(3);
		ll.addAfter(2, 119);
		ll.addToStart(39);
		ll.addToEnd(4);
		ll.printList();
	}
}
