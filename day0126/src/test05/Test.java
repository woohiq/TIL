package test05;

public class Test {
	public static void main(String[] args) {
		NormalBox b = new NormalBox();
		
		b.setData("Hello World!");
		String s = (String) b.getData();
	}
}
