package model;

public class Member {
	
	private String name;
	private String idNumber;
	private String gender;
	private String birthday;
	private boolean baptized;
	private boolean active;
	private String observations;
	private String phoneNumber;
	private String sector;
	private String committee;
	
	public Member(String name, String idNumber,String gender, String birthday, boolean baptized, boolean active, String observations,
			String phoneNumber, String sector, String committee) {
		this.name = name;
		this.idNumber = idNumber;
		this.gender = gender;
		this.birthday = birthday;
		this.baptized = baptized;
		this.active = active;
		this.observations = observations;
		this.phoneNumber = phoneNumber;
		this.sector = sector;
		this.committee = committee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public boolean isBaptized() {
		return baptized;
	}

	public void setBaptized(boolean baptized) {
		this.baptized = baptized;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getCommittee() {
		return committee;
	}

	public void setCommittee(String committee) {
		this.committee = committee;
	}
	
	
}
