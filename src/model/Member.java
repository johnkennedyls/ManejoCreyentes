package model;

public class Member {
	
	/**
	 * Member name
	 */
	private String name;
	/**
	 * Member ID
	 */
	private String idNumber;
	/**
	 * Member gender
	 */
	private String gender;
	/**
	 * Member birthay
	 */
	private String birthday;
	/**
	 * Represents if the member is baptized
	 * true = baptized
	 * false = unbaptized
	 */
	private boolean baptized;
	/**
	 * Represents if the member is promised
	 * true = promised
	 * false = not promised
	 */
	private boolean active;
	/**
	 * Notes for member
	 */
	private String observations;
	/**
	 * Member phoneNumber
	 */
	private String phoneNumber;
	/**
	 * Member sector
	 */
	private String sector;
	/**
	 * Member committee
	 */
	private String committee;
	private SectorType sectorType;
	private OfficeType officeType;
	
	/**
	 * Initialize a new member
	 * @param name:String Represents member name
	 * @param idNumber:String Represents member ID
	 * @param gender:String Represents member gender
	 * @param birthay:String Represents member birthay
	 * @param baptized:Boolean Indicate if the member is baptized
	 * @param active:Boolean Indicate if the member is promised
	 * @param observations:String Minister notes of the member
	 * @param phoneNumber:String Represents member phone number
	 * @param sector:String Represents member sector
	 * @param 
	 */
	public Member(String name, String idNumber,String gender, String birthday, boolean baptized, boolean active, String observations,
			String phoneNumber, String sector, String committee, SectorType sectorType, OfficeType officeType) {
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
		this.sectorType = sectorType;
		this.officeType = officeType;
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

	public SectorType getSectorType() {
		return sectorType;
	}

	public void setSectorType(SectorType sectorType) {
		this.sectorType = sectorType;
	}

	public OfficeType getOfficeType() {
		return officeType;
	}

	public void setOfficeType(OfficeType officeType) {
		this.officeType = officeType;
	}
	
	
}
