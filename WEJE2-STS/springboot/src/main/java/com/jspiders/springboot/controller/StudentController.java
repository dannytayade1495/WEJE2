package com.jspiders.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springboot.pojo.StudentPOJO;
import com.jspiders.springboot.response.StudentResponse;
import com.jspiders.springboot.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/add")
	public ResponseEntity<StudentResponse> 
				add(@RequestBody StudentPOJO student){
		StudentPOJO pojo = service.add(student);
		if (pojo != null) {
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("OK", "Student inserted", pojo, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("FAIL", "Student not inserted", null, null),
				HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/search{id}")
	public ResponseEntity<StudentResponse> search(@PathVariable int id){
		StudentPOJO student = service.search(id);
		if (student != null) {
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("OK", "Student found", student, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("FAIL", "Student not found", null, null),
				HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/searchByName")
	public ResponseEntity<StudentResponse> searchByName(@RequestParam String name){
		StudentPOJO student = service.searchByName(name);
		if (student != null) {
			return new ResponseEntity<StudentResponse>
			(new StudentResponse("OK", "Student found", student, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>
		(new StudentResponse("FAIL", "Student not found", null, null),
				HttpStatus.BAD_REQUEST);
	}

}
