package com.org.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.org.service.IWishService;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/wish-controller")
public class WishMessageOperationsController {

	@Autowired
	private IWishService service;
	
	@Autowired
	private ServletContext sc;
	
	@Autowired
	private ServletConfig cg;
	
	@Autowired
	private HttpSession ses; 
	
	
	@RequestMapping("/")
	public String showHomePage() {
		// return LVN (Logical View Name)
		return "welcome";
	}
	
	
	/*@RequestMapping   // In the recent versions of spring boot this RequestMapping is not supporting
	public String showHomePage() {
		// return LVN (Logical View Name)
		return "welcome";
	}*/
	
	
	/*
	@GetMapping("/")  
	public String showHomePage() {
		// return LVN (Logical View Name)
		System.out.println("WebApplication Name : "+sc.getContextPath());
		System.out.println("Web Application's Name : "+cg.getServletName());
		System.out.println("Session Id : "+ses.getId());
		System.out.println("WishMessageOperationsController.showHomePage()");
	//		return "forward:wish-controller/all";
		return "welcome";   
	}
	
	*/
	
	
	@GetMapping("/report")
	public String showReport() throws Exception {
		System.out.println("WishMessageOperationsController.showReport()");
		return "show_report";
	}
	
	
	@RequestMapping("/wish")
	public String fetchWishMessage(Map<String, Object> map) {
		
		System.out.println("Shared Memory location "+map.getClass());
		
		//use Service
		String msg = service.generateWishMessage("Hemanth Kumar");
		
		map.put("wMsg", msg);
		map.put("sysDate", new Date());
		
		return "show_result";
	}
	
	/*
		@RequestMapping("/wish")
		public String fetchWishMessage(Map<String, Object> map) {
			
			System.out.println("Shared Memory location "+map.getClass());
			
			//use Service
			String msg = service.generateWishMessage("Hemanth Kumar");
			
			map.put("wMsg", msg);
			map.put("sysDate", new Date());
			
			return "show_result";
		}*/

}
