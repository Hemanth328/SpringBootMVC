package com.org.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.org.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showStudentFormPage(@ModelAttribute("stud") Student st) {
		st.setAvg(92.46f);
		return "student_form";
	}
	
	@PostMapping("/register")
	public String registerStudent(Map<String, Object> map, @ModelAttribute Student st) {
		
		System.out.println(st);
		
		return "registered_form";
	}

}
