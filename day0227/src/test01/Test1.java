package test01;

public class Test1 {
	public static void main(String[] args) {
		SinglyLinkedStack stack = new SinglyLinkedStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
