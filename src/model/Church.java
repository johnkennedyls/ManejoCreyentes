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
	
	private Sector theSector;
	private List<Sector> theSectors;
	private List<Member> generalMembers;
	
	public Church(String name, String city) {
		this.name = name;
		this.city = city;
		
		theSectors = new ArrayList<Sector>();
		generalMembers = new ArrayList<Member>();
	}
	
	public  void readMembers(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();
		
		String line = br.readLine();
		
		while (line != null) {
			String[] split = line.split(",");
			Member member = new Member(split[0], split[1], split[2], split[3],
					Boolean.parseBoolean(split[4]),Boolean.parseBoolean(split[5]), split[6], split[7], split[8], split[9]);
			
			generalMembers.add(member);
			line = br.readLine();
		}

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
