package com.jspiders.springcorexml.bean;

import java.util.List;

import lombok.Data;

@Data
public class FatherBean {
	
	private int id;
	private String name;
	private List<ChildBean> children;

}
