package test1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test3 {
	public static void main(String[] args) throws IOException {
		
		// 예외처리 따로 x
		// try with resource
		// try다음 ()가 오는데 이 안에 필요한 리소스 정의
		// 그럼 블록 안에서 리소스 사용 가능, 블록 넘어가면 자동으로 close
		try (FileInputStream in = new FileInputStream("newjeans.jpg"); 
			FileOutputStream out = new FileOutputStream("newjeans-copy3.jpg")){
			
			// 버퍼를 사용
			byte[] buffer = new byte[10];
			int read;
			
			while((read = in.read(buffer)) != -1) {
				// 매 번 in.read할 때마다 buffer에 byte정보 저장해서 받아옴
				// read : 어디까지 읽으면 되는지
				out.write(buffer, 0, read);
				System.out.println(Arrays.toString(buffer)+","+read);
			}
			System.out.println("복사완료");
			System.out.println("알아서 stream을 닫아줌");
		} 
	}
}
