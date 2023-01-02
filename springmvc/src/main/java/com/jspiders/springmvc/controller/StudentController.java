package com.jspiders.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.pojo.StudentPOJO;
import com.jspiders.springmvc.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) StudentPOJO login, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		return "Home";
	}

	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam String username, @RequestParam String password,
			ModelMap map) {
		StudentPOJO student = service.login(username, password);
		if (student != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", student);
			session.setMaxInactiveInterval(30);
			return "Home";
		}
		map.addAttribute("msg", "Inavlid username or password..!!");
		return "LoginForm";
	}

	@GetMapping("/add")
	public String add(@SessionAttribute(name = "login", required = false) StudentPOJO login, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		return "AddStudent";
	}

	@PostMapping("/add")
	public String addData(@SessionAttribute(name = "login", required = false) StudentPOJO login,
			@RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String city, @RequestParam String username, @RequestParam String password, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		StudentPOJO student = service.add(name, email, contact, city, username, password);
		if (student != null) {
			map.addAttribute("student", student);
		} else {
			map.addAttribute("msg", "Data not added.!");
		}
		return "AddStudent";
	}

	@GetMapping("/search")
	public String search(@SessionAttribute(name = "login", required = false) StudentPOJO login, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		return "SearchStudent";
	}

	@PostMapping("/search")
	public String searchData(@SessionAttribute(name = "login", required = false) StudentPOJO login,
			@RequestParam int id, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		StudentPOJO student = service.search(id);
		if (student != null) {
			map.addAttribute("student", student);
		} else {
			map.addAttribute("msg", "Data not found..!!");
		}
		return "SearchStudent";
	}

	@GetMapping("/update")
	public String update(@SessionAttribute(name = "login", required = false) StudentPOJO login, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		return "UpdateStudent";
	}

	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false) StudentPOJO login,
			@RequestParam int id, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		StudentPOJO student = service.search(id);
		if (student != null) {
			map.addAttribute("student", student);
		} else {
			map.addAttribute("msg", "Data not found..!!");
			List<StudentPOJO> students = service.searchAll();
			map.addAttribute("students", students);
		}
		return "UpdateStudent";
	}

	@PostMapping("/updateData")
	public String updateData(@SessionAttribute(name = "login", required = false) StudentPOJO login,
			@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam long contact,
			@RequestParam String city, @RequestParam String username, @RequestParam String password, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		StudentPOJO student = service.search(id);
		if (student != null) {
			service.update(id, name, email, contact, city, username, password);
			map.addAttribute("msg", "Student updated successfully..!!");
			List<StudentPOJO> students = service.searchAll();
			map.addAttribute("students", students);
		}
		return "UpdateStudent";
	}

	@GetMapping("/remove")
	public String remove(@SessionAttribute(name = "login", required = false) StudentPOJO login, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		return "RemoveStudent";
	}

	@PostMapping("/remove")
	public String removeData(@SessionAttribute(name = "login", required = false) StudentPOJO login,
			@RequestParam int id, ModelMap map) {
		if (login == null) {
			map.addAttribute("msg", "Login first to proceed..!!");
			return "LoginForm";
		}
		StudentPOJO student = service.remove(id);
		if (student != null) {
			map.addAttribute("msg", "Student removed successfully");
		} else {
			map.addAttribute("msg", "Data not found..!!");
		}
		List<StudentPOJO> students = service.searchAll();
		map.addAttribute("students", students);
		return "RemoveStudent";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "Successfully logged out..!!");
		return "LoginForm";
	}
}
