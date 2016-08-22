package com.contactApp.action;

public class UserInfoData {
	private String uid;
	private String fname;
	private String lname;
	private String dob;
	private String ssn;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	public UserInfoData() {
		
	}
	
	public UserInfoData(String uid, String fname, String lname, String dob, String ssn, String street, String city, String state, String zip) {
		this.setUid(uid);
		this.fname = fname;
		this.lname = lname;
		this.dob = dob;
		this.ssn = ssn;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
}
