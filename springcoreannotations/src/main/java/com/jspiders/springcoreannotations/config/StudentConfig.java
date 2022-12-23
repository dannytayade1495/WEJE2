package com.jspiders.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotations.bean.StudentBean;

public class StudentConfig {
	
	@Bean("student2")
	public StudentBean getStudent2() {
		StudentBean student = new StudentBean
				(3, "Amar", "amar@gmail.com",
						9876543210L, "Pune");
		return student;
	}
	
	@Bean("student1")
	public StudentBean getStudent1() {
		return new StudentBean();
	}
	
	@Bean
	public StudentBean getStudent() {
		StudentBean student = new StudentBean();
		student.setId(1);
		student.setName("Raju");
		student.setEmail("paisadouble@scam.com");
		student.setContact(9876543210L);
		student.setCity("Mumbai");
		return student;
	}
	
	
	
	
}
