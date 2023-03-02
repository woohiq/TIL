package test01;

import java.util.Arrays;

public class Test4 {
	public static void main(String[] args) {
		String str = "상섬청년SW아카데미";
		char[] arr = str.toCharArray();
		
		for (int i = 0; i<arr.length/2; i++) {
			char tmp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = tmp;
		
		}
		
		System.out.println(Arrays.toString(arr));
		
		String str2 = String.valueOf(arr);
		System.out.println(str2);
		
		StringBuffer sb = new StringBuffer();
		char[] arr3 = new char[arr.length];
		for (int i = 0; i<arr3.length; i++) {
			sb.append(arr[i]);
			
		}
		System.out.println(sb.toString());
		
	}
}
