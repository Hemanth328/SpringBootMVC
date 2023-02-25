package com.org.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.org.model.PoliticianProfile;

@Controller
public class PoliticianOPerationsController {
	
	@GetMapping("/")
	public String showHome() {
		System.out.println("PoliticianOPerationsController.showHome()");
	    
		return "home";
	}
	
	
	@GetMapping("/register")
	public String showFormpage(@ModelAttribute("pp") PoliticianProfile profile) {
		System.out.println("PoliticianOPerationsController.enclosing_method()");
		
		return "politician_register";
	}
	
	@PostMapping("/register")
	public String registerPolitician(@ModelAttribute("pp") PoliticianProfile profile) {
		
		System.out.println("PoliticianOPerationsController.registerPolitician()");
		System.out.println("model class object data : "+profile);
		
		return "show_result";
	}
	
	@InitBinder
	public void myDateBinder(WebDataBinder binder) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}

}
