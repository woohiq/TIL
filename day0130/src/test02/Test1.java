package test02;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test1 {
	public static void main(String[] args) {
		//method1("ssafy");
		try {
			method2("input.txt");
		} catch (FileNotFoundException e) {
			System.out.println("ckecked 니까 반드시 처리");
		}
	}
	public static void method1(String str) {
		// NumberFormatException : unchecked exception
		// 예외처리 하지 않아도 컴파일은 됨
		int num = Integer.parseInt(str);
	}
	// throws 키워드를 이용해서
	// 내 메서드 안에서 일어날 수 있는 예외를
	// 호출한 곳에서 전가
	public static void method2(String filename) throws FileNotFoundException {
		// FileNotFoundException : checked exception
		// 컴파일 되지 않음
		FileReader reader = new FileReader(filename);
	}
}
