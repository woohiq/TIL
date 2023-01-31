package test03_multiple_implements;

public class Test {
	public static void main(String[] args) {
		Duck d = new Duck();
		Eagle e = new Eagle();
		
		// 다형성
		AbleToFly f = d;
		f.fly();
		d.hunt();
	}
}
