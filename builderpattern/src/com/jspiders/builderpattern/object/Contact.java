package com.jspiders.builderpattern.object;

public class Contact {
	
	String firstName;
	String middleName;
	String lastName;
	long mobileNo;
	long landlineNo;
	String email;
	String address;
	String company;
	String dob;

	public Contact(String firstName, String middleName, 
			String lastName, long mobileNo, 
			long landlineNo, String email,
			String address, String company, String dob) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.landlineNo = landlineNo;
		this.email = email;
		this.address = address;
		this.company = company;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Contact"
				+ "\nFirst Name : " + firstName + 
				"\nMiddle Name : " + middleName + 
				"\nLast Name : " + lastName
				+ "\nMobile Number : " + mobileNo + 
				"\nLandline Number : " + landlineNo + 
				"\nEmail : " + email + 
				"\nAddress : " + address
				+ "\nCompany : " + company + 
				"\nDate of birth : " + dob;
	}

}