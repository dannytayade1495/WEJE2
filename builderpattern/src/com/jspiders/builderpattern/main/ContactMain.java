package com.jspiders.builderpattern.main;

import com.jspiders.builderpattern.builder.ContactBuilder;
import com.jspiders.builderpattern.object.Contact;

public class ContactMain {
	
	public static void main(String[] args) {
		Contact contact = new ContactBuilder()
				.fName("Nora").mNo(9876543210L)
				.getContact();
		System.out.println(contact);
		
		System.out.println();
		
		Contact contact2 = new ContactBuilder()
				.mNo(8976543210L).lName("Kohli")
				.fName("Virat").getContact();
		System.out.println(contact2);
	}

}
