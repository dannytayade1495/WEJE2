package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class WifeDTO {
	
	@Id
	private int id;
	
	private String name;
	
	private String email;
	
	private int age;
	
	private long contact;
	
	@OneToOne
	private HusbandDTO husband;

}
