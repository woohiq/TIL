package test04;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Test1 {
	public static void main(String[] args) {
		// 자바스크립트 객체의 배열 -> 객체의 배열 혹은 객체의 리스트
		
		Person[] arr = new Person[3];
		arr[0] = new Person("Lee", 30);
		arr[1] = new Person("Yang", 30);
		arr[2] = new Person("Park", 30);
		Gson gson = new Gson();
		
		String str1 = gson.toJson(arr);
		System.out.println(str1);
		
		List<Person> list = new ArrayList<Person>();
		list.add(arr[0]);
		list.add(arr[1]);
		list.add(arr[2]);
		
		String str2 = gson.toJson(list);
		System.out.println(str2);
	}
}
