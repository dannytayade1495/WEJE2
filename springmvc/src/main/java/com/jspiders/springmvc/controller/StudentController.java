package com.jspiders.springmvc.controller;

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
		return "Home";
	}
	
	@GetMapping("/add")
	public String add() {
		return "AddStudent";
	}
	
	@PostMapping("/add")
	public String addData(@RequestParam String name,
			@RequestParam String email,
			@RequestParam long contact,
			@RequestParam String city,
			@RequestParam String username,
			@RequestParam String password,
			ModelMap map) {
		StudentPOJO student = service.add(name, email,
				contact, city, username, password);
		if (student != null) {
			map.addAttribute("student", student);
		} else {
			map.addAttribute("msg", "Data not added.!");
		}
		return "AddStudent";
	}
	
	@GetMapping("/search")
	public String search() {
		return "SearchStudent";
	}
	
	@PostMapping("/search")
	public String searchData(@RequestParam int id,
			ModelMap map) {
		StudentPOJO student = service.search(id);
		if (student != null) {
			map.addAttribute("student", student);
		} else {
			map.addAttribute("msg", "Data not found..!!");
		}
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

	@GetMapping("/logout")
	public String logout() {
		return "LoginForm";
	}
}
