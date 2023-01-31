package test3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		test1("FileReader         FileWriter");
		test2("BufferedReader BufferedWriter");
	}
	
	public static void test1(String testname) throws FileNotFoundException, IOException {
		try(FileReader reader = new FileReader("big_input.txt");
			FileWriter writer = new FileWriter("big_input-copy2.txt")){
			long start = System.nanoTime();
			int c;
			while((c = reader.read())!= -1) {
				writer.write(c);;
			}
			long end = System.nanoTime();
			System.out.printf("%s - %15d ns.\n",testname,end-start);
		}
	}
	//보조스트림
	public static void test2(String testname) throws FileNotFoundException, IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader("big_input.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("big_input-copy3.txt"))){
			long start = System.nanoTime();
			// bufferedReader Writer는 character하나씩 읽어오는게 아니고 String한줄씩
			String line;
			while((line = reader.readLine())!= null) {
				writer.write(line);
				writer.newLine();
			}
			long end = System.nanoTime();
			System.out.printf("%s - %15d ns.\n",testname,end-start);
		}
	}
}
