package com.jspiders.hibernatemanytomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductDTO {
	
	@Id
	private int id;
	
	private String name;
	
	private double price;
	
	private String category;
	
//	@ManyToMany
//	private List<CustomerDTO> customers;

}
