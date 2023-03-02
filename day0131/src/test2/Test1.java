package test2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test1 {
	public static void main(String[] args) throws IOException {
		// character stream -> reader, writer
		
		try(FileReader reader = new FileReader("big_input.txt");
			FileWriter writer = new FileWriter("big_input-copy.txt")){
			
			int c; // character를 int에 담음
			while((c = reader.read()) != -1) {
				writer.write(c);;
			}
			System.out.println("복사완");
			System.out.println("try with resource구문으로 알아서 리소스 정리");
		}
	}
}
