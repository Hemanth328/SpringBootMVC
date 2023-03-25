package com.org.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleOperationsController {
	
	@GetMapping("/")
	public String sampleMethod(Map<String, Object> map) {
		
		map.put("sysDate", LocalDateTime.now());
		map.put("wishMsg", "Good Morning");
		return "welcome";
	}
}
