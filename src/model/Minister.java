package model;

import java.util.ArrayList;
import java.util.List;

public class Minister {

	private String name;
	private String password;
	
	private Church theChurch;
	private List<Church> myChurchs;
	
	public Minister(String name, String password) {
		this.name = name;
		this.password = password;
		
		myChurchs = new ArrayList<Church>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Church> getMyChurchs() {
		return myChurchs;
	}


	public void createChurch(String name, String city) {
			
		theChurch = new Church(name, city);
		myChurchs.add(theChurch);
	}
}
