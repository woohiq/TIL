package test01;

public class Test2 {
	public static void main(String[] args) {
		int[] nums = {10};
		try {
		System.out.println(nums[1]);
		} catch(ArrayIndexOutOfBoundsException e) {
			// ArrayIndexOutofBoundsException이거나 이 거의 자식만 가능
			// 그래서 ArrayIndex에러가 아니면 처리못함
			// catch안에 Exception이면 모든 Exception 처리가능
			System.out.println("배열 크기 초과");
			System.out.println("에러 메세지 : "+e.getMessage());
			e.printStackTrace();
		}
	}
}
