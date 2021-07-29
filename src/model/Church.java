package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import exceptions.InvalidRouteException;

import java.lang.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;

public class Church {
	
	private static final long serialVersionUID = 1;
	public final static String SAVE_PATH_FILE_SECTORS = "data/sectors.xd";
	public final static String SAVE_PATH_FILE_COMMITTEES = "data/committees.xd";
	public final static String SAVE_PATH_FILE_MEMBERS = "data/members.xd";
	public final static String SAVE_PATH_FILE_VISITED_MEMBERS = "data/visitedMembers.xd";
	public final static String SAVE_PATH_FILE_NO_VISITED_MEMBERS = "data/noVisitedMembers.xd";
	private List<Sector> theSectors;
	private List<Committee> theCommittees;
	private List<Member> generalMembers;
	private List<Member> visited;
	private static List<Member> noVisited;

	private String name;
	/**
	 * 
	 */
	private String city;
	
	private Minister minister;
	

	

	public Church(String name, String city) {
		this.name = name;
		this.city = city;
		


		theSectors = new ArrayList<Sector>();
		theCommittees = new ArrayList<Committee>();
		generalMembers = new ArrayList<Member>();
		visited = new ArrayList<Member>();
		noVisited = new ArrayList<Member>();
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




	public List<Sector> getTheSectors() {
		return theSectors;
	}
	
	
	
	public List<Committee> getTheCommittees() {
		
		return theCommittees;
	}

	public void setTheCommittees(List<Committee> theCommittees) {
		this.theCommittees = theCommittees;
	}
	
	

	public List<Member> getGeneralMembers() {
		return generalMembers;
	}

	public void setGeneralMembers(List<Member> generalMembers) {
		this.generalMembers = generalMembers;
	}

	public void setTheSectors(List<Sector> theSectors) {
		this.theSectors = theSectors;
	}
	
	

	public Minister getMinister() {
		return minister;
	}

	public void setMinister(Minister minister) {
		this.minister = minister;
	}

	public List<Member> getVisited() {
		return visited;
	}

	public void setVisited(List<Member> visited) {
		this.visited = visited;
	}

	public static List<Member> getNoVisited() {
		return noVisited;
	}

	public void setNoVisited(List<Member> noVisited) {
		this.noVisited = noVisited;
	}

	@SuppressWarnings("null")
	public void createGeneralMember(String name, String idNumber, String gender, String birthday, boolean baptized,
			boolean active, String observations, String phoneNumber, String sector, String committee, OfficeType charge) throws IOException {
		
		Member theMember = null;
		Sector theSector = null;
		Committee theCommittee = null;
		
		theMember = new Member(name, idNumber, gender, birthday, baptized, active, observations, phoneNumber, sector, committee, charge);
		
		generalMembers.add(theMember);
		
		if (theMember.getSector() != "ninguno") {
			//theSector.getMembersList().add(theMember);
			for (int i = 0; i < theSectors.size(); i++) {
				if (theMember.getSector().equalsIgnoreCase(theSectors.get(i).getName())) {
					theSectors.get(i).addMemberToSector(theMember);
				}else {
					createSector(theMember.getSector());
					theSectors.get(theSectors.size()-1).addMemberToSector(theMember);;
				}
			}
			if (theMember.getCommittee() != "ninguno") {
				//theCommittee.getcMembersList().add(theMember);
				for (int i = 0; i < theCommittees.size(); i++) {
					if (theMember.getCommittee().equalsIgnoreCase(theCommittees.get(i).getName())) {
						theCommittees.get(i).addMemberToCommittee(theMember);
					}else {
						createCommittee(theMember.getCommittee());
						theCommittees.get(theCommittees.size()-1).addMemberToCommittee(theMember);
					}
				}
			}
		}
		noVisited.add(theMember);
		writeMember(theMember);
		saveData("member");
	}

	private void writeMember(Member theMember) throws IOException {
		
		FileWriter fichero = null;
		
		
		fichero = new FileWriter("data/memberscsv.csv", true);
		BufferedWriter bw=new BufferedWriter(fichero);
		

		bw.write("\n"+theMember.getName() + ";" + theMember.getIdNumber() + ";" + theMember.getGender()
		+ ";" + theMember.getBirthday()+ ";" +theMember.isBaptized()+ ";" +theMember.isActive()+ ";" +
		theMember.getObservations()+ ";" +theMember.getPhoneNumber()+ ";" +	theMember.getSector()+ ";" +
		theMember.getCommittee()+ ";" +theMember.getCharge());
		bw.close();
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
					Boolean.parseBoolean(split[4]),Boolean.parseBoolean(split[5]), split[6], split[7], split[8], split[9] ,OfficeType.valueOf(split[10]));
			

			generalMembers.add(member);
			line = br.readLine();
		}

	}
	
	public void createCommittee(String name) throws IOException {
		
		Committee theCommittee;
		
		theCommittee = new Committee(name);
		theCommittees.add(theCommittee);
		saveData("committee");
	}

	public void createSector(String name) throws IOException {

		Sector theSector;

		theSector = new Sector(name);
		theSectors.add(theSector);
		saveData("sector");

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

	public void divideBySectors() throws IOException {
		for (int i = 0; i < generalMembers.size(); i++) {
			if (existSector(generalMembers.get(i).getSector())) {
				Sector s = searchSector(generalMembers.get(i).getSector());
				s.addMemberToSector(generalMembers.get(i));
			} else {
				createSector(generalMembers.get(i).getSector());
				Sector s = searchSector(generalMembers.get(i).getSector());
				s.addMemberToSector(generalMembers.get(i));
			}
		}

	}
	
	public boolean existCommittee(String name) {
		boolean exist = false;
		for (int i = 0; i < theCommittees.size(); i++) {
			if (theCommittees.get(i).getName().equals(name)) {
				exist = true;
			}
		}

		return exist;

	}

	public Committee searchCommittee(String name) {
		Committee s = null;
		for (int i = 0; i < theCommittees.size(); i++) {
			if (theCommittees.get(i).getName().equals(name)) {
				s = theCommittees.get(i);
			}
		}

		return s;

	}

	public void divideByCommittee() throws IOException {
		for (int i = 0; i < generalMembers.size(); i++) {
			if (existCommittee(generalMembers.get(i).getCommittee())) {
				Committee s = searchCommittee(generalMembers.get(i).getCommittee());
				s.addMemberToCommittee(generalMembers.get(i));
			} else {
				createCommittee(generalMembers.get(i).getCommittee());
				Committee s = searchCommittee(generalMembers.get(i).getCommittee());
				s.addMemberToCommittee(generalMembers.get(i));
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
				
				String textForUnbirthDay = "";
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
					textForUnbirthDay = "Restan " + p.getMonths() + " meses, y " + p.getDays()
					+ " días para su próximo cumpleaños. (" + totalDias + " días en total)";
					member.setTextForUnbirthday(textForUnbirthDay);
					member.setDaysForBirthay((int) totalDias);
					notBirthayPeople.add(member);

				}
			} catch (DateTimeParseException exc) {
				System.out.printf("Error: %s no es una fecha válida!%n", member.getBirthday());
			}
		}
		Collections.sort(notBirthayPeople, new BirthayComparator());
		
		return notBirthayPeople;
	}
	
	//Searching metods
	
	public List<Member> searchByName(String searched) {
		List<Member> returned = new ArrayList<Member>();
		for (Member member : generalMembers) {
			if(member.getName().contains(searched)) {
				returned.add(member);
			}
		}
		return returned;
	}
	
	public List<Member> searchByIdNumber(String searched) {
		List<Member> returned = new ArrayList<Member>();
		for (Member member : generalMembers) {
			if(member.getIdNumber().contains(searched)) {
				returned.add(member);
			}
		}
		return returned;
	}
	
	public List<Member> searchByGender(String searched) {
		List<Member> returned = new ArrayList<Member>();
		for (Member member : generalMembers) {
			if(member.getGender().contains(searched)) {
				returned.add(member);
			}
		}
		return returned;
	}
	
	public List<Member> searchByPhoneNumber(String searched) {
		List<Member> returned = new ArrayList<Member>();
		for (Member member : generalMembers) {
			if(member.getPhoneNumber().contains(searched)) {
				returned.add(member);
			}
		}
		return returned;
	}
	
public List<Member> buscarPorBautizados(boolean vf) {
		
		List<Member> listafinal = new ArrayList<Member>();
		for (int i = 0; i < generalMembers.size(); i++) {
			if (generalMembers.get(i).isBaptized() == vf) {
				listafinal.add(generalMembers.get(i));
			}
		}
		return listafinal;
	}
public List<Member> buscarPorNoBautizados(boolean vf) {
	
	List<Member> listafinal = new ArrayList<Member>();
	for (int i = 0; i < generalMembers.size(); i++) {
		if (generalMembers.get(i).isBaptized() == false) {
			listafinal.add(generalMembers.get(i));
		}
	}
	return listafinal;
}
	
	public List<Member> buscarPorActivo(boolean ac) {
		
		List<Member> listafinal = new ArrayList<Member>();
		for (int i = 0; i < generalMembers.size(); i++) {
			if (generalMembers.get(i).isActive() == ac) {
				listafinal.add(generalMembers.get(i));
			}
		}
		return listafinal;
	}
public List<Member> buscarPorInactivo(boolean ac) {
		
		List<Member> listafinal = new ArrayList<Member>();
		for (int i = 0; i < generalMembers.size(); i++) {
			if (generalMembers.get(i).isActive() == false) {
				listafinal.add(generalMembers.get(i));
			}
		}
		return listafinal;
	}
	
	public List<Member> buscarPorSector(String sec) {
		
		List<Member> listafinal = new ArrayList<Member>();
		for (int i = 0; i < generalMembers.size(); i++) {
			if (generalMembers.get(i).getSector().equalsIgnoreCase(sec)) {
				listafinal.add(generalMembers.get(i));
			}
		}
		return listafinal;
	}
	
	public List<Member> buscarPorComite(String com) {
		
		List<Member> listafinal = new ArrayList<Member>();
		for (int i = 0; i < generalMembers.size(); i++) {
			if (generalMembers.get(i).getCommittee().equalsIgnoreCase(com)) {
				listafinal.add(generalMembers.get(i));
			}
		}
		return listafinal;
	}
	
	public void moveTovisited(Member theMember) throws IOException {
		if(theMember.isVisited() == false) {
			theMember.setVisited(true);
			noVisited.remove(searchByName(theMember.getName()).get(0));
			visited.add(theMember);
			saveData("visited");
		}
	}
	public void moveToNovisited(Member theMember) throws IOException {
		if(theMember.isVisited() == true) {
			theMember.setVisited(false);
			visited.remove(searchByName(theMember.getName()).get(0));
			noVisited.add(theMember);
			saveData("noVisited");
		}
	}
	
	public void importData(String fileName) throws IOException, InvalidRouteException {
		
		if(fileName.equals("data/sectors.csv")) {
			importSectorsData("data/sectors.csv");
		}
		else if (fileName.equals("data/committees.csv")) {
			importCommitteesData("data/committees.csv");
		}
		else if(fileName.equals("data/members.csv")) {
			importMembersData("data/members.csv");
		}
		else if(fileName.equals("data/visitedMembers.csv")) {
			importVisitedMembersData("data/visitedMembers.csv");
		}
		else if(fileName.equals("data/noVisitedMembers.csv")) {
			importNoVisitedMembersData("data/noVisitedMembers.csv");
		}
		else {
			throw new InvalidRouteException();
		}
	}
	
	public void importSectorsData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		br.readLine();
		String line = br.readLine();
		while(line!=null){
			String[] parts = line.split(";");
			createSector(parts[0]);	
			line = br.readLine();
		}
		br.close();
		
		
	}
	
	public void importCommitteesData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		br.readLine();
		String line = br.readLine();
		while(line!=null){
			String[] parts = line.split(";");
			createCommittee(parts[0]);	
			line = br.readLine();
		}
		br.close();
		
		
	}
	
	public void importMembersData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		br.readLine();
		String line = br.readLine();
		while(line!=null){
			String[] parts = line.split(";");
			createGeneralMember(parts[0], parts[1], parts[2], parts[3],
					Boolean.parseBoolean(parts[4]),Boolean.parseBoolean(parts[5]), parts[6], parts[7], parts[8],
					parts[9] ,OfficeType.valueOf(parts[10]));	
			line = br.readLine();
		}
		br.close();
		
		
	}
	
	public void importVisitedMembersData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		br.readLine();
		String line = br.readLine();
		while(line!=null){
			String[] parts = line.split(";");
			Member theMember = new Member(parts[0], parts[1], parts[2], parts[3],
					Boolean.parseBoolean(parts[4]),Boolean.parseBoolean(parts[5]), parts[6], parts[7], parts[8],
					parts[9] ,OfficeType.valueOf(parts[10]));
			moveTovisited(theMember);	
			line = br.readLine();
		}
		br.close();
		
		
	}

	public void importNoVisitedMembersData(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		br.readLine();
		String line = br.readLine();
		while(line!=null){
			String[] parts = line.split(";");
			Member theMember = new Member(parts[0], parts[1], parts[2], parts[3],
					Boolean.parseBoolean(parts[4]),Boolean.parseBoolean(parts[5]), parts[6], parts[7], parts[8],
					parts[9] ,OfficeType.valueOf(parts[10]));
			moveToNovisited(theMember);	
			line = br.readLine();
		}
		br.close();
		
		
	}
	
	public void saveData(String type) throws IOException{
		if(type.equalsIgnoreCase("sector")) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_SECTORS));
			oos.writeObject(theSectors);
			oos.close();
		} 
		if(type.equalsIgnoreCase("committee")) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_COMMITTEES));
			oos.writeObject(theCommittees);
			oos.close();
		}
		if(type.equalsIgnoreCase("member")) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_MEMBERS));
			oos.writeObject(generalMembers);
			oos.close();
		}
		if(type.equalsIgnoreCase("visited")) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_VISITED_MEMBERS));
			oos.writeObject(visited);
			oos.close();
		}
		if(type.equalsIgnoreCase("noVisited")) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_NO_VISITED_MEMBERS));
			oos.writeObject(noVisited);
			oos.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public String loadData() throws IOException, ClassNotFoundException{
		File sector = new File(SAVE_PATH_FILE_SECTORS);
		File committee = new File(SAVE_PATH_FILE_COMMITTEES);
		File member = new File(SAVE_PATH_FILE_MEMBERS);
		File visited = new File(SAVE_PATH_FILE_VISITED_MEMBERS);
		File noVisited = new File(SAVE_PATH_FILE_NO_VISITED_MEMBERS);
		String info = "";
		boolean loaded = false;
		if(sector.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sector));
			theSectors = (ArrayList<Sector>)ois.readObject();
			info += "Restaurants loaded succesfully\n";
			ois.close();	
			loaded = true;
		}
		if(committee.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(committee));
			theCommittees = (ArrayList<Committee>)ois.readObject();
			info += "Clients loaded succesfully\n";
			ois.close();
			loaded = true;
		}
		if(member.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(member));
			generalMembers = (ArrayList<Member>)ois.readObject();
			info += "Products loaded succesfully\n";
			ois.close();
			loaded = true;
		} 
		if(visited.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(visited));
			this.visited = (ArrayList<Member>)ois.readObject();
			info += "Orders loaded succesfully\n";
			ois.close();
			loaded = true;
		}
		if(noVisited.exists()){
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(visited));
			Church.noVisited = (ArrayList<Member>)ois.readObject();
			info += "Orders loaded succesfully\n";
			ois.close();
			loaded = true;
		}
		if(loaded == false) {
			info = "Nothing to load";
		}
		return info;
	}
	
	
	
	
}
