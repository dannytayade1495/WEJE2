package com.jspiders.springcoreannotations.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {

//	@Value("2")
	private int id;
	
//	@Value("Shyam")
	private String name;
	
//	@Value("shyam@gmail.com")
	private String email;
	
//	@Value("9876543210")
	private long contact;
	
//	@Value("Mumbai")
	private String city;

}
