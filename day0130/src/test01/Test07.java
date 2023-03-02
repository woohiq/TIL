package test01;

public class Test07 {
	public static void main(String[] args) {
		try {
			
			String str = "1234";
			System.out.println("code 1 -> before parse : "+str);
			int num = Integer.parseInt(str);
			System.out.println("code 2 -> after parse : "+str);
			return;
		} catch(Exception e) {
			System.out.println("code 3 -> excetion handling 완료");
		} finally {
			// 언제나 실행 O
			System.out.println("code 4 -> 언제나 실행");
		}
		// 언제나 실행되진 않음 try블록이나 catch블록이나 finally 블록 안에 return 이 있다면 종료
		System.out.println("code 5 -> 언제나 실행 ?");
		
		// 왜 finally중요 ?
		// DB연결 할 때 사용
		// -연결을 종료할 때 관련 리소스 정리할 필요 
		// 파일 입출력할때도 사용
		// -입출력 Stream 관련된 리소스 정리
	}
}
