package com.ssafy.manager;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Person;

public class PersonManager {
	private List<Person> list = new ArrayList<>();
	
	private static PersonManager manager = new PersonManager();
	
	public static PersonManager getInstance() {
		return manager;
	}
	
	private PersonManager() {}
	
	public void regist(Person person) {
		list.add(person);
	}
	
	public List<Person> getAll(){
		return list;
	}
}
