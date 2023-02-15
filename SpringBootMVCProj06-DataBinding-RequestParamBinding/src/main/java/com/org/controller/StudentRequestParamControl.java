package com.org.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentRequestParamControl {
	
	
	//In this case request param names and handler method param names are different
	/*	@GetMapping("/data")
		public String process(@RequestParam("sid")int sid, @RequestParam("sname") String name) {
			System.out.println(sid+"    "+name);
			return "registered_form";
		}
	*/
	
	//If reuqest param names are matching with handler method param name then there is no need of giving
	//  request param names in @RequestParam annotation
	/*	@GetMapping("/data")
		public String process(@RequestParam int sid, @RequestParam String sname) {
			System.out.println(sid+"    "+sname);
			return "registered_form";
		}*/
	
	
	//By default @RequestParam based method param value should be filledup because value for required annotation
	// in @RequestParam is true
	/*	@GetMapping("/data")
		public String process(@RequestParam int sid, @RequestParam(required = false, defaultValue= "Major") String sname) {
			System.out.println(sid+"    "+sname);
			return "registered_form";
		}*/
	
	
	/*	
	//	If we pass more than the required parameters in requestParam though it wont give any error
		// http://localhost:8080/SpringBootMVCProj06-DataBinding-RequestParamBinding/data?sid=5642&sname=Uri
		@GetMapping("/data")
		public String process(@RequestParam int sid) {
			System.out.println(sid);
			return "registered_form";
		}
		*/
	
	/*	// Here the request params for sid is int if we pass other data type values then it will throw Number format exception
		@GetMapping("/data")
		public String process(@RequestParam int sid, @RequestParam String sname) {
			System.out.println(sid+"    "+sname);
			return "registered_form";
		}*/
	
	
	/*// If no value is set to sid then it takes the given default value given in defaultValue attribute
	@GetMapping("/data")
	public String process(@RequestParam(name= "sid", defaultValue = "6458") int sid, @RequestParam String sname) {
		System.out.println(sid+"    "+sname);
		return "registered_form";
	}*/
	
	
	/*// If no value is passed to RequestParam sid then it will take the default value of Integer as null cause it is a wrapper type
	@GetMapping("/data")
	public String process(@RequestParam(name= "sid", required=false) Integer sid, @RequestParam String sname) {
		System.out.println(sid+"    "+sname);
		return "registered_form";
	}*/
	
	/*
	@GetMapping("/data")
	public String process(@RequestParam(name= "sid", required=false) Integer sid, 
			              @RequestParam String sname,
			              @RequestParam("sadd") String sadd[],
			              @RequestParam("sadd") List<String> listadd,
			              @RequestParam("sadd") Set<String> setadd) {
		System.out.println(sid+"    "+sname+"  "+Arrays.toString(sadd)+"  "+listadd+"  "+setadd);
		return "registered_form";
	}
	*/
	
	// If we take param as simple String(sadd) and we are trying to give multiple values through requestParam the simple 
	//string param holds the multiple values as the comma separated list of values 
	@GetMapping("/data")
	public String process(@RequestParam(name= "sid", required=false) Integer sid, 
			              @RequestParam String sname,
			              @RequestParam("sadd") String sadd) {
		System.out.println(sid+"    "+sname+"  "+sadd);
		return "registered_form";
	}
	
}
