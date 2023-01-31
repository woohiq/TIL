package test01;

public class Test6 {
	public static void main(String[] args) {
		//try~catch~catch
		try {
			int[] nums = new int[0];
			System.out.println(nums[1]);
			// 다른 예외라면 처리 X
			// | 연산자를 이용해서 하나의 catch 블록에서 다양한 종류의 예외 처리 가능
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
			System.out.println("하나의 블록에서 세 가지 처리");
		}  catch (Exception e) {
			System.out.println("모든 예외 처리");
		}
	}
}
