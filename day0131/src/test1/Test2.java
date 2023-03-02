package test1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args) throws IOException {
		
		// 예외처리 따로 x
		// try with resource
		// try다음 ()가 오는데 이 안에 필요한 리소스 정의
		// 그럼 블록 안에서 리소스 사용 가능, 블록 넘어가면 자동으로 close
		try (FileInputStream in = new FileInputStream("newjeans.jpg"); 
			FileOutputStream out = new FileOutputStream("newjeans-copy2.jpg")){
			int b; // byte를 int에 담음
			while((b = in.read()) != -1) {
				out.write(b);
			}
			System.out.println("복사완료");
			System.out.println("알아서 stream을 닫아줌");
		} 
	}
}
