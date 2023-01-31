package test02;

public class Test {
	public static void main(String[] args) {
		// 인터페이스는 객체를 생성할 수 없지만
		// 해당 인터페이스를 구현한 클래스로 객체 생성이 가능
		HdmiOutput monitor = new Monitor(); // 다형성
		
		HdmiInput computer = new Computer();
		
		HdmiOutput television = new Television();
		
		HdmiInput supercomputer = new SuperComputer();
		computer.setOutput(monitor);
		computer.show();
		computer.setOutput(television);
		computer.show();
		
		supercomputer.setOutput(television);
		supercomputer.show();
		
		// 왜 interface를 쓰까 ?
		// 인터페이스를 구현하기만 하면 어떤 클래스의 객체든 사용할 수 있다면 코드를 고칠 필요가 없다
	}
	 
}
