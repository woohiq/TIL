package test01;

public class Test1 {
	
	static int[] arr = new int[10];
	static int top = -1;
	
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		
		print();
		while(!isEmpty()) {
			System.out.println(pop());
		}
		
	}
	
	public static void push(int x) {
		if(isFull()) {
			System.out.println("stack overflow");
		} else {
			arr[++top] = x;
		}
	}
	
	public static int pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		} else {
			return arr[top--];
		}
	}
	
	static boolean isEmpty() {
		return top == -1;
	}
	
	static boolean isFull() {
		return top == arr.length-1;
	}
	
	static void print() {
		for (int i = top; i>=0; i--) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
