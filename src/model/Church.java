package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;

public class Church {
	
	/**
	 * 
	 */

	private String name;
	/**
	 * 
	 */
	private String city;
	
	//private Minister minister;
	
	/**
	 * 
	 */

	private List<Sector> theSectors;
	private List<Committee> theCommittees;
	private List<Member> generalMembers;

	public Church(String name, String city) {
		this.name = name;
		this.city = city;

		//this.minister = new Minister("admin", "123");	

		theSectors = new ArrayList<Sector>();
		theCommittees = new ArrayList<Committee>();
		generalMembers = new ArrayList<Member>();
	}

	// ------------------------------------------------------
	// ------------------------------------------------------
	// Getters and setters
	// -----------------------------------------------------
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

	
//	public Minister getMinister() {
//		return minister;
//	}
//
//	public void setMinister(String name, String password) {
//		
//		Minister tempMinister = new Minister(name, password);
//		this.minister = tempMinister;
//		
//	}


	public List<Sector> getTheSectors() {
		return theSectors;
	}
	
	@SuppressWarnings("null")
	public void createGeneralMember(String name, String idNumber, String gender, String birthday, boolean baptized,
			boolean active, String observations, String phoneNumber, String sector, String committee, OfficeType charge) {
		
		Member theMember = null;
		Sector theSector = null;
		Committee theCommittee = null;
		
		theMember = new Member(name, idNumber, gender, birthday, baptized, active, observations, phoneNumber, sector, committee, charge);
		
		generalMembers.add(theMember);
		
		if (theMember.getSector() != "ninguno") {
			theSector.getMembersList().add(theMember);
			if (theMember.getCommittee() != "ninguno") {
				theCommittee.getcMembersList().add(theMember);
			}
		} 
	}

	public void readMembers(String fn) throws IOException {
		File fl = new File(fn);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(fl));
		br.readLine();

		String line = br.readLine();

		while (line != null) {
			String[] split = line.split(";");

			Member member = new Member(split[0], split[1], split[2], split[3],
					Boolean.parseBoolean(split[4]),Boolean.parseBoolean(split[5]), split[6], split[7], split[8], split[9] /*OfficeType.valueOf(split[10])*/);
			

			generalMembers.add(member);
			line = br.readLine();
		}

	}

	public void createSector(String name) {

		Sector theSector;

		theSector = new Sector(name);
		theSectors.add(theSector);

	}

	public boolean existSector(String name) {
		boolean exist = false;
		for (int i = 0; i < theSectors.size(); i++) {
			if (theSectors.get(i).getName().equals(name)) {
				exist = true;
			}
		}

		return exist;

	}

	public Sector searchSector(String name) {
		Sector s = null;
		for (int i = 0; i < theSectors.size(); i++) {
			if (theSectors.get(i).getName().equals(name)) {
				s = theSectors.get(i);
			}
		}

		return s;

	}

	public void divideBySectors() {
		for (int i = 0; i < generalMembers.size(); i++) {
			if (existSector(generalMembers.get(i).getSector())) {
				Sector s = searchSector(generalMembers.get(i).getSector());
				s.addMember(generalMembers.get(i));
			} else {
				createSector(generalMembers.get(i).getSector());
				Sector s = searchSector(generalMembers.get(i).getSector());
				s.addMember(generalMembers.get(i));
			}
		}

	}

	/**
	 * Show members whose birthday is today
	 * 
	 * @return birthayPeople:ArrayList<Member> birthay boys
	 */
	public ArrayList<Member> ToListodayBirthays() {
		ArrayList<Member> birthayPeople = new ArrayList<Member>();

		for (Member member : generalMembers) {
			try {
				/* Fecha actual */
				LocalDate today = LocalDate.now();

				/* Fecha de nacimiento. Ambas formas son válidas */
				LocalDate birthday = LocalDate.parse(member.getBirthday());
				LocalDate nextBDay = birthday.withYear(today.getYear());

				/* Si el cumpleaños ya ocurrió este año, agrega 1 año */
				if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
					nextBDay = nextBDay.plusYears(1);
				}

				Period p = Period.between(today, nextBDay);
				long totalDias = ChronoUnit.DAYS.between(today, nextBDay);

				/* Cuando totalDias=365 hoy es el cumpleaños */

				if (totalDias == 365) {
					birthayPeople.add(member);
					System.out.println("¡Su cumpleaños es hoy. Felicidades!");

				}
			} catch (DateTimeParseException exc) {
				System.out.printf("Error: %s no es una fecha válida!%n", member.getBirthday());
			}
		}
		return birthayPeople;
	}

	public ArrayList<Member> ToListnextBirthays() {
		ArrayList<Member> notBirthayPeople = new ArrayList<Member>();
		for (Member member : generalMembers) {
			try {
				/* Fecha actual */
				LocalDate today = LocalDate.now();

				/* Fecha de nacimiento. Ambas formas son válidas */
				LocalDate birthday = LocalDate.parse(member.getBirthday());
				LocalDate nextBDay = birthday.withYear(today.getYear());

				/* Si el cumpleaños ya ocurrió este año, agrega 1 año */
				if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
					nextBDay = nextBDay.plusYears(1);
				}

				Period p = Period.between(today, nextBDay);
				long totalDias = ChronoUnit.DAYS.between(today, nextBDay);

				/* Cuando totalDias=365 hoy es el cumpleaños */

				if (totalDias != 365) {
					System.out.println("Restan " + p.getMonths() + " meses, y " + p.getDays()
							+ " días para su próximo cumpleaños. (" + totalDias + " días en total)");
					notBirthayPeople.add(member);

				}
			} catch (DateTimeParseException exc) {
				System.out.printf("Error: %s no es una fecha válida!%n", member.getBirthday());
			}
		}
		Collections.sort(notBirthayPeople, new BirthayComparator());
		System.out.println(notBirthayPeople.get(0).getName());
		return notBirthayPeople;
	}
}
