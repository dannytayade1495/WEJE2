package com.jspiders.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.StudentPOJO;
import com.jspiders.springrest.response.StudentResponse;
import com.jspiders.springrest.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping(path = "/add",
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StudentResponse> 
	add(@RequestBody StudentPOJO student) {
		StudentPOJO pojo = service.add(student);
		StudentResponse response = new StudentResponse();
		if (pojo != null) {
			response.setMsg("OK");
			response.setDescription
				("Student added successfully..!!");
			response.setStudent(student);
			return new ResponseEntity<StudentResponse>
					(response, HttpStatus.ACCEPTED);
		}
		response.setMsg("FAIL");
		response.setDescription("Student not added..!!");
		return new ResponseEntity<StudentResponse>
			(response, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(path = "/search{id}",
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StudentResponse> 
		search(@PathVariable int id){
		StudentPOJO pojo = service.search(id);
		if (pojo != null) {
			return new ResponseEntity<StudentResponse>
			(new StudentResponse
			("OK", "Student Data Found..!!", pojo, null),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>
		(new StudentResponse
		("FAIL", "Student Not Found", null, null),
				HttpStatus.BAD_REQUEST);
	}

}
