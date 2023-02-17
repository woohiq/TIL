package test01;

public class Test3 {
	public static void main(String[] args) {
		System.out.println(atoi("3903593"));
		System.out.println(itoa(32592358));
	}
	
	public static int atoi(String string) {
		char[] arr = string.toCharArray();
		int value = 0;
		
		int digit;
		
		for (int i = 0; i<arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				digit = arr[i] - '0';
				value *= 10;
				value += digit;				
			} else {
				break;
			}
		}
		
		return value;
	}
	
	public static String itoa(int value) {
		StringBuffer sb = new StringBuffer();
		
		int tmp = value;
		while(tmp > 0) {
			char c = (char)(tmp % 10 + '0');
			sb.append(c);
			tmp /= 10;
		}
		return sb.reverse().toString();
	}
}
