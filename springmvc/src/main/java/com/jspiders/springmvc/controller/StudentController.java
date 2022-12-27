package com.jspiders.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home() {
		return "Home";
	}

	@PostMapping("/login")
	public String login() {
		StudentPOJO pojo = service.login();
		if(pojo != null) {
			return "Home";
		}
		return "LoginForm";
	}
	
	@GetMapping("/add")
	public String add() {
		return "AddStudent";
	}
	
	@GetMapping("/search")
	public String search() {
		return "SearchStudent";
	}
	
	@GetMapping("/update")
	public String update() {
		return "UpdateStudent";
	}
	
	@GetMapping("/remove")
	public String remove() {
		return "RemoveStudent";
	}

}
