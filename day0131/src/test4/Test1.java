package test4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//scanner vs bufferedReader
		// big_input.txt에서 한 줄씩 읽어와서정수형으로 바꾸기
		
		
		test1("Scanner       ");
		test2("BufferedReader");
		test3("BufferedReader");
	}
	
	public static void test1(String testname) throws FileNotFoundException, IOException {
		try(Scanner sc = new Scanner(new FileInputStream("big_input.txt"))){
			long start = System.nanoTime();
			while(sc.hasNext()) {
				int num = sc.nextInt();
			}
			long end = System.nanoTime();
			System.out.printf("%s - %15d ns.\n",testname,end-start);
		}
	}
	public static void test2(String testname) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("big_input.txt")))){
			long start = System.nanoTime();
			
			String l;
			while ((l = br.readLine()) != null) {
				int num = Integer.parseInt(l);
			}
			
			long end = System.nanoTime();
			System.out.printf("%s - %15d ns.\n",testname,end-start);
		}
	}
	public static void test3(String testname) throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("big_input.txt"))){
			long start = System.nanoTime();
			
			String l;
			while ((l = br.readLine()) != null) {
				int num = Integer.parseInt(l);
			}
			
			long end = System.nanoTime();
			System.out.printf("%s - %15d ns.\n",testname,end-start);
		}
	}
}
