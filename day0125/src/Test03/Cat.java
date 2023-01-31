package Test03;

// 일반 클래스인데 추상 클래스를 상속받음
public class Cat extends Animal {
	// 추상클래스를 상속 받은 클래스는
	// 추상메서드를 모두 override 해야한다
	
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("야옹");
	}
	public void eat() {
		System.out.println("생선냠냠");
	}
}
