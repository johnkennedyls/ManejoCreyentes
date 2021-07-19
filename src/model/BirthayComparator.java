package model;

import java.util.Comparator;
import java.time.*;

public class BirthayComparator implements Comparator<Member> {

	@Override
	public int compare(Member m1, Member m2) {
		int rpta = 0;
		if (m1.getDaysForBirthay() > m2.getDaysForBirthay()) {
			rpta = 1;
		}else if(m1.getDaysForBirthay() < m2.getDaysForBirthay()) {
			rpta = -1;
		}else {
			rpta = 0;
		}
		return rpta;
		
		
	}
	
}
