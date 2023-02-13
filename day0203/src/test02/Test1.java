package test02;

import java.util.ArrayList;

import com.google.gson.Gson;

public class Test1 {
	public static void main(String[] args) {
		Person p1 = new Person("Yang", 38, true, null, new ArrayList<String>());
		p1.hobbies.add("Youtube");
		p1.hobbies.add("Cooking");
		
		System.out.println(p1);
		Gson gson = new Gson();
		String str = gson.toJson(p1);
		System.out.println(str);
		Person p2 = gson.fromJson(str, Person.class);
		System.out.println(p2);
	}
}
