package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.HusbandBean;

public class HusbandWifeMain {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("HusbandWifeConfig.xml");
		
		HusbandBean husband = (HusbandBean)context.
				getBean("husband1");
		
		System.out.println(husband);
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
