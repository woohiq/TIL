package stack;

public class HansangbinStack implements Stack{
	// Array를 활용해서 구현해봅시다 

	public static void main(String[] args) {
		// 오랜만이야 생성자 :) 
		HansangbinStack myStack = new HansangbinStack(5);
		
		System.out.println(myStack.isFull());
		System.out.println(myStack.isEmpty());
		myStack.pop();
		myStack.push(3);
		System.out.println(myStack.isFull());
		System.out.println(myStack.isEmpty());
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		myStack.push(4);
		System.out.println(myStack.isFull());
		System.out.println(myStack.pop());
		System.out.println(myStack.peek());
		myStack.printStack();
		myStack.clear();
		myStack.printStack();
		
		
	}
	
	static int top; // 스택의 포인터
	static int N; // 스택의 크기
	static int stack[]; // 스택
	
	// 생성자를 활용해서 스택 생성
	public HansangbinStack (int stackSize) {
		top = -1; // 스택 포인터 초기화
		N = stackSize;
		stack = new int[N]; // 스택 생성
	}
	
	
	public boolean isEmpty() {
		// 비었으면 -1
		return(top == -1);
	}

	
	public boolean isFull() {
		// 다 찼으면 N-1
		return (top == N-1);
	}

	
	public void push(int value) {
		// 스택 전부 찼으면 범위 넘어감 오류
		if (isFull()) {
			System.out.println("stack out of range error");
			return;
		}
		// top을 늘리고 그 자리에 값을 넣기
		else {
			stack[++top] = value;
		}
		
	}

	
	public int pop() {
		// 빈 스택 오류
		if(isEmpty()) {
			System.out.println("empty stack error");
			return -1;
		}
		// 탑의 원소를 반환하고 탑의 값을 1줄임
		else return(stack[top--]);
	}

	
	public int peek() {
		// 빈 스택 오류
		if (isEmpty()) {
			System.out.println("empty stack error");
			return -1;
		}
		// 탑의 원소 반환만
		else return(stack[top]);
		
	}

	
	public void clear() {
		// 이미 빈 스택
		if (top == -1) {
			System.out.println("already empty stack");
			return;
		} 
		// top을 -1로만 줄이면 됨
		else top = -1;
		
	}

	
	public void printStack() {
		if (top == -1) {
			System.out.println("empty");
			return;
		}
		// 결과 출력을 위한 새로운 변수
		int tmp = top;
		// 변수를 1씩 줄이면서 출력
		while(tmp >= 0) {
			System.out.print(stack[tmp--]+" ");
		}
		System.out.println();
	}
	
}
