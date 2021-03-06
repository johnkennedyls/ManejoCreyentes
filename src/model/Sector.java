package model;

import java.util.ArrayList;
import java.util.List;

public class Sector {

	private String name;

	private List<Member> leaders;
	private List<Member> membersList;

	public Sector(String name) {
		this.name = name;

		membersList = new ArrayList<Member>();
		leaders = new ArrayList<Member>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getLeaders() {
		return leaders;
	}

	public List<Member> getMembersList() {
		return membersList;
	}
	
	/*
	public void createLeaders(String name, String idNumber, String gender, String birthday, boolean baptized,
			boolean active, String observations, String phoneNumber, String sector, String committee, OfficeType charge) {
		
		Member theMember;

		theMember = new Member(name, idNumber, gender, birthday, baptized, active, observations, phoneNumber, sector,
				committee, charge);
		leaders.add(theMember);
	}
	*/
	
	public void addMemberToSector(Member m) {
		membersList.add(m);
	}
}
