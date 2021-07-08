package model;

import java.util.ArrayList;
import java.util.List;

public class Committee {
	/**
	 * return  Committee name
	 * @return name:String Committee name
	 */
	private String name;
	private List<Member> cMembersList;
	
	/**
	 * 
	 */
	public Committee(String name) {
		
		this.name = name;
		
		cMembersList = new ArrayList<Member>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getcMembersList() {
		return cMembersList;
	}

}
