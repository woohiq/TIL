package test08_comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return Integer.parseInt(o1.getId())-Integer.parseInt(o2.getId());
	}
	
}
