package com.jspiders.serializationdeserialization.objects;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID =
			-8182600630861422764L;

	int id;
	
	String userName;
	
	String password;

	public User(int id, String userName, 
			String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + 
	userName + ", password=" + password + "]";
	}
	
}
