package com.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-controller")
public class TestController {
	
	@GetMapping("/all")
	public String showDataTest() throws Exception {
		System.out.println("TestController.showDataTest()");
		return "show_data_Test";
	}

}
