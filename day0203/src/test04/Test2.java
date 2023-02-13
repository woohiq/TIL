package test04;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class Test2 {
	public static void main(String[] args) {
		String str = "[{\"name\":\"Lee\",\"age\":30},{\"name\":\"Yang\",\"age\":30},{\"name\":\"Park\",\"age\":30}]";
		Person[] arr;
		Gson gson = new Gson();
		arr = gson.fromJson(str, Person[].class);
		System.out.println(Arrays.toString(arr));
		List<Person> list = Arrays.asList(arr);
		System.out.println(list);
	}
}
