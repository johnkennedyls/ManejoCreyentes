package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Church {
	
	private String name;
	private String city;
	
	private Minister minister;
	
	private Sector theSector;
	private List<Sector> theSectors;
	private List<Member> generalMembers;
	
	public Church(String name, String city) {
		this.name = name;
		this.city = city;
		
		this.minister = new Minister("admin", "123");
		
		theSectors = new ArrayList<Sector>();
		generalMembers = new ArrayList<Member>();
	}
	
	
	
	//------------------------------------------------------
	//------------------------------------------------------
    //Getters and setters
	//-----------------------------------------------------
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
	
	public Minister getMinister() {
		return minister;
	}

	public void setMinister(String name, String password) {
		Minister tempMinister = new Minister(name, password);
		this.minister = tempMinister;
		
	}

	public List<Sector> getTheSectors() {
		return theSectors;
	}
	
	
	public  void readMembers(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(";");
			Member member = new Member(split[0], split[1], split[2], split[3],
					Boolean.parseBoolean(split[4]),Boolean.parseBoolean(split[5]), split[6], split[7], split[8], split[9]);
			
			generalMembers.add(member);
			line = br.readLine();
		}

	}

	
	
	public void createSector(String name) {
		
		theSector = new Sector(name);
		theSectors.add(theSector);
	
	}
	
	public boolean existSector(String name){
		boolean exist = false;
		for (int i = 0; i < theSectors.size(); i++) {
			if(theSectors.get(i).getName().equals(name)) {
				exist = true;
			}
		}
		
		return exist;
		
	}
	
	public Sector searchSector(String name){
		Sector s = null;
		for (int i = 0; i < theSectors.size(); i++) {
			if(theSectors.get(i).getName().equals(name)) {
				s=theSectors.get(i);
			}
		}
		
		return s;
		
	}
	
	public void divideBySectors() {
		for (int i = 0; i < generalMembers.size(); i++) {
			if(existSector(generalMembers.get(i).getSector())) {
				Sector s = searchSector(generalMembers.get(i).getSector());
				s.addMember(generalMembers.get(i));
			}else {
				createSector(generalMembers.get(i).getSector());
				Sector s = searchSector(generalMembers.get(i).getSector());
				s.addMember(generalMembers.get(i));
			}
		}
		
	}
	
	
	public void divideByCommittee() {
		
	}
	
}
