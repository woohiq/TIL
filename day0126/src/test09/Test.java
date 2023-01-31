package test09;

public class Test {
	public static void main(String[] args) {
		GenericBox<Student> studentBox = new GenericBox<>();
		GenericBox<Person> personBox = new GenericBox<>();
		GenericBox<Object> objectBox = new GenericBox<>();
		
		// ? : 어떤 타입이등 가능
		GenericBox<?> allBox = objectBox;
		allBox = personBox;
		allBox = studentBox;
		
		// ? extends T : T또는 그 자손만
		GenericBox<? extends Person> personAndChild = personBox;
		personAndChild = studentBox;
		//GenericBox<? extends Person> personAndChild = bjectBox; 불가
		
		GenericBox<? super Person> personAndObject = personBox;
		personAndObject = objectBox;
		//GenericBox<? super Person> personAndObject = studentBox; 불가
	}
}
