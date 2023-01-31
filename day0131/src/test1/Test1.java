package test1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		// 예외처리 따로 x
		// try ~ finally 
		// 언제나 실행 -> 사용중인 자원 반납
		try {
			in = new FileInputStream("newjeans.jpg");
			out = new FileOutputStream("newjeans-copy.jpg");
			
			int b; 
			while((b = in.read()) != -1) {
				out.write(b);
			}
			System.out.println("복사완료");
		} finally {
			if (in != null) in.close();
			if (out != null) out.close();
			System.out.println("리소스 닫고 종료");
		}
	}
}
