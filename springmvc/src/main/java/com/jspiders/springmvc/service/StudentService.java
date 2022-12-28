package com.jspiders.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO login(String username, String password) {
		StudentPOJO pojo = repository.login(username, password);
		return pojo;
	}

	public StudentPOJO add(String name, String email, long contact, String city, String username, String password) {
		StudentPOJO pojo = repository.add(name, email,
				contact, city, username, password);
		return pojo;
	}

}
