package com.jspiders.springcorexml.bean;

import lombok.Data;

@Data
public class ChildBean1 {
	
	private int id;
	private String name;
	private FatherBean1 father;

}
