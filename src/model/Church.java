package model;

import java.util.ArrayList;
import java.util.List;

public class Church {
	
	private String name;
	private String city;
	
	private Sector theSector;
	private List<Sector> theSectors;
	
	public Church(String name, String city) {
		this.name = name;
		this.city = city;
		
		theSectors = new ArrayList<Sector>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Sector> getTheSectors() {
		return theSectors;
	}
	
	public void createSector(String name) {
		
		theSector = new Sector(name);
		theSectors.add(theSector);
	}
}
