package stack;

public interface Stack {
	boolean isEmpty();
	boolean isFull();
	void push(int value);
	int pop();
	int peek();
	void clear();
	void printStack();
}
