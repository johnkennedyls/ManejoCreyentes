package model;

import java.util.ArrayList;
import java.util.List;

public class Minister {
	/**
	 * Minister name
	 */
	private String name;
	/**
	 * Minister password
	 */
	private String password;
	/**
	 * Minister churchs
	 */
	private List<Church> myChurchs;

	/**
	 * Initialize a new minister
	 * 
	 * @param name:String     Minister name
	 * @param password:String Minister password
	 */
	public Minister(String name, String password) {
		this.name = name;
		this.password = password;

		myChurchs = new ArrayList<Church>();
	}

	/**
	 * return minister name
	 * 
	 * @return name:String Minister name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Minister name
	 * 
	 * @param name:String Minister name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * return Minister password
	 * 
	 * @return passwors:String Minister password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set Minister passworde
	 * 
	 * @param password:String Minister password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Return minister churchs
	 * @return myChurchs:Church Churchs list
	 */
	public List<Church> getMyChurchs() {
		return myChurchs;
	}
/**
 * Create a new church
 * @param name:String Church name
 * @param city:String City name
 */
	public void createChurch(String name, String city) {

		Church theChurch;
		theChurch = new Church(name, city);
		myChurchs.add(theChurch);
	}
}
