package test03;

import java.util.ArrayList;

import com.google.gson.Gson;

public class Test1 {
	public static void main(String[] args) {
		Person p = new Person("lee", 30, false, null, new ArrayList<String>(), new ArrayList<Person>());
		p.hobbies.add("Youtube");
		p.hobbies.add("Movie");
		
		p.friends.add(new Person("Park", 20, true, null, new ArrayList<String>(), new ArrayList<Person>()));
		p.friends.add(new Person("Park", 20, true, null, new ArrayList<String>(), new ArrayList<Person>()));
		
		System.out.println(p);
		
		Gson gson = new Gson();
		String str1 = gson.toJson(p);
		System.out.println(str1);
		
	}
}
