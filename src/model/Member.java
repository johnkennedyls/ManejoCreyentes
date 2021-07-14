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
	/**
	 * Member charge
	 */
	private OfficeType charge;
	
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
	 * @param Committee:
	 * @param carge:
	 */
	public Member(String name, String idNumber,String gender, String birthday, boolean baptized, boolean active, String observations,
			String phoneNumber, String sector, String committee, OfficeType charge) {
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
		this.charge = charge;
	}
	/**
	 * return member name
	 * @return name:String Member name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set member name
	 * @param name:String Member name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * return member ID
	 * @return idNumber:String Member ID
	 */
	public String getIdNumber() {
		return idNumber;
	}
	/**
	 * set member ID
	 * @param idNumber:String Member ID
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	/**
	 * return member gender
	 * @return gender:String Member gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * set member gender
	 * @param gender:String Member gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * return member birthday
	 * @return birthay:String Member birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * Set member birthday
	 * @param birthday:String Member birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * Return if member is baptized
	 * @return baptized:boolean true:if member is baptized false: if member is not baptized
	 */
	public boolean isBaptized() {
		return baptized;
	}
	/**
	 * Set if member is baptized
	 * @param baptized:boolean true:if member is baptized false:if member is not baptized
	 */
	public void setBaptized(boolean baptized) {
		this.baptized = baptized;
	}
	/**
	 * Return if member is promised
	 * @return active:boolean true:if member is promised false: if member is not promised
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * Set if member is promised
	 * @param active:boolean true:if member is promised false:if member is not promised
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * return member observations
	 * @return observations:String Member observations
	 */
	public String getObservations() {
		return observations;
	}
	/**
	 * Set member birthday
	 * @param birthday:String Member birthday
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}
	/**
	 * return member phone
	 * @return phoneNumber:String Member phone
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Set member phone
	 * @param phoneNumber:String Member phone
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * return member sector
	 * @return sector:String Member sector
	 */
	public String getSector() {
		return sector;
	}
	/**
	 * Set member sector
	 * @param sector:String Member sector
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}
	/**
	 * return member committee
	 * @return committee:String Member committee
	 */
	public String getCommittee() {
		return committee;
	}
	/**
	 * Set member committee
	 * @param committee:String Member committee
	 */
	public void setCommittee(String committee) {
		this.committee = committee;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", idNumber=" + idNumber + ", gender=" + gender + ", birthday=" + birthday
				+ ", baptized=" + baptized + ", active=" + active + ", observations=" + observations + ", phoneNumber="
				+ phoneNumber + ", sector=" + sector + ", committee=" + committee + "]";
	}
	
	
	/**
	 * 
	 * @return
	 */
	public OfficeType getCharge() {
		return charge;
	}
	/**
	 * 
	 * @param charge
	 */
	public void setCharge(OfficeType charge) {
		this.charge = charge;
	}
	
	
	
}
