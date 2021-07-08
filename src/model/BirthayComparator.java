package model;

import java.util.Comparator;

public class BirthayComparator implements Comparator<Member> {

	@Override
	public int compare(Member m1, Member m2) {
		
		return m1.getBirthday().compareTo(m2.getBirthday());
	}
	
}
