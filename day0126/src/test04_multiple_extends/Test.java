package test04_multiple_extends;

public class Test {
	public static void main(String[] args) {
		DuckInterface2 d1 = new Duck();
		DuckInterface2 d2 = new UglyDuckling();
		DuckInterface2 d3 = new DonaldDuck();
		
		d1.playInnocent();
		d2.playInnocent();
		d3.playInnocent();
	}
}

