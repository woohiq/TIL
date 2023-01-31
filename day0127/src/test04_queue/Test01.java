package test04_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Test01 {
	public static void main(String[] args) {
		// queue 
		// FIFO
		// 구현으로 linked list사용
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i<10; i++) {
			queue.offer(i);
		}
		while(!queue.isEmpty()){
			System.out.print(queue.poll()+" ");
		}
	}
	
	

}
