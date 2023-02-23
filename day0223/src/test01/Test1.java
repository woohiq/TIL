package test01;

public class Test1 {
	
	// 원형 큐
	public static int n = 5;
	public static int[] arr = new int[n];
	public static int front = 0, rear = 0;
	
	public static void main(String[] args) {
		enQueue(1);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		enQueue(5);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
		enQueue(6);
		enQueue(7);
		enQueue(8);
		enQueue(9);
		enQueue(10);
	}
	
	public static boolean isEmpty() {
		return front == rear;
	}
	
	public static boolean isFull() {
		return front == (rear+1)%n;
	}
	
	public static void enQueue(int item) {
		if (isFull()) {
			System.out.println("큐가 가득 차서 원소를 넣는데 실패하였습니다");
		} else {
			rear = (rear+1)%n;
			arr[rear] = item;
		}
	}
	
	public static int deQueue() {
		if (isEmpty()) {
			System.out.println("큐가 비어있어 원소를 빼는데 실패하였습니다");
			return -1;
		} else {
			front = (front+1)%n;
			return arr[front];
		}
		
	}
}
