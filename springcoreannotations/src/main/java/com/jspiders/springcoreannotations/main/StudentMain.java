package com.jspiders.springcoreannotations.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.
			AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotations.bean.
			StudentBean;
import com.jspiders.springcoreannotations.config.
			StudentConfig;

public class StudentMain {
	
	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext
				(StudentConfig.class);
		
//		StudentBean student = context.
//				getBean(StudentBean.class);
		
//		StudentBean student = (StudentBean)context.
//				getBean("student1");
		
		StudentBean student = (StudentBean)context.
				getBean("student2");
		
		System.out.println(student);
		
		((AnnotationConfigApplicationContext)context).
												close();
		
	}

}
