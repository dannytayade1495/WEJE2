package com.jspiders.builderpattern.builder;

import com.jspiders.builderpattern.object.Contact;

public class ContactBuilder {

	private String firstName;
	private String middleName;
	private String lastName;
	private long mobileNo;
	private long landlineNo;
	private String email;
	private String address;
	private String company;
	private String dob;

	public ContactBuilder fName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ContactBuilder mName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public ContactBuilder lName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactBuilder email(String email) {
		this.email = email;
		return this;
	}

	public ContactBuilder address(String address) {
		this.address = address;
		return this;
	}

	public ContactBuilder comp(String company) {
		this.company = company;
		return this;
	}

	public ContactBuilder dob(String dob) {
		this.dob = dob;
		return this;
	}

	public ContactBuilder mNo(long mobileNo) {
		this.mobileNo = mobileNo;
		return this;
	}

	public ContactBuilder lNo(long landlineNo) {
		this.landlineNo = landlineNo;
		return this;
	}
	
	public Contact getContact() {
		Contact contact = new Contact(this.firstName, 
				this.middleName, this.lastName, 
				this.mobileNo, this.landlineNo, 
				this.email, this.address, 
				this.company, this.dob);
		return contact;
	}

}