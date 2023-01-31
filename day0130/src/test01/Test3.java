package test01;

public class Test3 {
	public static void main(String[] args) {
		//try~catch~catch
		try {
			int num = Integer.parseInt("ssafy");
			int[] nums = new int[0];
			System.out.println(nums[1]);
		} catch (NumberFormatException e) {
			System.out.println("해당 문자열은 정수로 바꿀 수 없다");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위 넘어감");
		} catch (Exception e) {
			System.out.println("모든 예외 처리");
		}
	}
}
