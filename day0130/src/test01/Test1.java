package test01;

public class Test1 {
	public static void main(String[] args) {
		int[] nums = {10};
		//System.out.println(nums[1]);
//		System.out.println(nums[-1]);
		
//		int num = 5/0;
		
//		int num = Integer.parseInt("123");
//		int numExcep = Integer.parseInt("ssafy");
		
		// 예외는 언제?
		// throw 키워드 사용해서 new 예외생성자() -> 예외객체 -> 던지면발생
		// 예외 발생 -> 내부적으로는 예외 객체 생성 후 throw
		// throw new ArrayIndexOutOfBoundsException();
		
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("예외실행");
		}
	}
}
