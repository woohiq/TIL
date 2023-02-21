public interface Stack {
	/*
	 * stack
	 * 하나의 자료구조 LIFO
	 * 
	 * 1. 비어있는지 확인
	 * 2. 전부 차 있는지 확인
	 * 3. push
	 * 4. pop
	 * 5. peek
	 * 6. clear
	 * 7. 출력
	 */
	public boolean isEmpty();
	public boolean isFull();
	public void push(int value);
	public void pop();
	public void peek();
	public void clear();
	public void print();
	
}
