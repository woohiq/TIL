package test01;

public class Test2 {
	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}
