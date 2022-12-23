package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.FatherBean;

public class FatherChildMain {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext
				("FatherChildConfig.xml");
		
		FatherBean father = context.
				getBean(FatherBean.class);
		
		System.out.println(father);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
