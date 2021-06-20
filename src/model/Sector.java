package model;

import java.util.ArrayList;
import java.util.List;

public class Sector {

	private String name;

	private Member theMember;
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

	public void createLeaders(String name, String idNumber, String gender, String birthday, boolean baptized,
			boolean active, String observations, String phoneNumber, String sector, String committee, SectorType sectorType, OfficeType officeType) {

		theMember = new Member(name, idNumber, gender, birthday, baptized, active, observations, phoneNumber, sector,
				committee, sectorType, officeType);
		leaders.add(theMember);
	}

	public void createMembers(String name, String idNumber, String gender, String birthday, boolean baptized,
			boolean active, String observations, String phoneNumber, String sector, String committee, SectorType sectorType, OfficeType officeType) {

		theMember = new Member(name, idNumber, gender, birthday, baptized, active, observations, phoneNumber, sector,
				committee, sectorType, officeType);
		membersList.add(theMember);
	}

	public void addMember(Member m) {
		membersList.add(m);
	}
}
