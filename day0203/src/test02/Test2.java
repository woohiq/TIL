package test02;

import com.google.gson.Gson;

public class Test2 {
	public static void main(String[] args) {
		// Json -> 자바 객체 (멤버 변수로 리스트가 있음)
		
		String str = "{\"name\":\"Yang\",\"age\":38,\"hungry\":true,\"hobbies\":[\"Youtube\",\"Cooking\"]}";
		Gson gson = new Gson();
		Person p1 = gson.fromJson(str, Person.class);
		System.out.println(p1);
	}
}
