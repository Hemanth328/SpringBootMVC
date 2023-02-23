package com.org.controller;

import java.util.Map;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.model.Employee;
import com.org.service.IEmployeeMgmtService;
import com.org.validations.EmployeeValidator;

import jakarta.servlet.http.HttpSession;


@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empServ;
	
	@Autowired
	private EmployeeValidator  emplValidator;
	
	@GetMapping("/")
	public String showhome() {
		System.out.println("EmployeeOperationsController.showhome()");
		return "home";
	}
	
	
	/*@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map ) {
		List<Employee> list = empServ.getAllEmployees();
		map.put("empsData", list);
		System.out.println(list);
		return "employee_report";
	}*/
	
	
	
	
	@GetMapping("/report")
	public String showEmployeeReport(@PageableDefault(page=0, size = 5, sort="empno", direction = Sort.Direction.ASC) Pageable pageable,Map<String, Object> map ) {
		
		Page<Employee> page = empServ.getAllEmployeesPageData(pageable);
		map.put("empsData", page);
		return "employee_report";
	}
	
	
	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {  // Launching the form Employee registration form page with default Job description
		
		emp.setJob("Team Lead");
		
		return "employee_register";
	}
	
	
	/*	
	 *   // request scope
		@PostMapping("/add")
		public String addEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
			
			String result = empServ.registerEmployee(emp); // After registering the Employee collecting the id value
			// after registering placing want to place all the Employee in shared memory
			
			// request scope
			map.put("resultMsg", result); // placing the result in shared memory this is a session scope so as the request redirects to another
			// request path the data stored in shared memory will be wiped off
			
			
			return "redirect:report";  // here this is redirecting to report so that only once add employee method logic executes
			
		}
		*/
	
	
	/*
	// redirect scope
	@PostMapping("/add")
	public String addEmployee(RedirectAttributes redatt, @ModelAttribute("emp") Employee emp) {
		
		String result = empServ.registerEmployee(emp); // After registering the Employee collecting the id value
	   // after registering placing want to place all the Employee in shared memory
		
		// redirect scope
		redatt.addFlashAttribute("resultMsg",result); // This will store the data in redirect scope once the page is refreshed this data
		// will go off
		
		return "redirect:report";  // here this is redirecting to report so that only once add employee method logic executes
		
	}
	
	*/
	
	
	
	/*
	// Session scope
	@PostMapping("/add")
	public String addEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp) {
		
		String result = empServ.registerEmployee(emp); // After registering the Employee collecting the id value
	   // after registering placing want to place all the Employee in shared memory
		
		// session scope
		ses.setAttribute("resultMsg",result); // This will store the data in session scope even after page is refreshed  for n times this data
		// will remains until the sessions lost's
		
		return "redirect:report";  // here this is redirecting to report so that only once add employee method logic executes
		
	}
	*/
	
	
	@PostMapping("/add")
	public String addEmployee(HttpSession ses, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		
        if(emp.getVflag().equalsIgnoreCase("no")) {
			
			//checking for type miss match errors
			if(errors.hasFieldErrors())
				return "employee_register";
			
			// checking form validation errors
			if(emplValidator.supports(emp.getClass())) {
				emplValidator.validate(emp, errors);
				
				if(errors.hasErrors()) {
					return "employee_register";
				}
			}
		}
		
		// application logical errors
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "employee_register";
		}
		
		String result = empServ.registerEmployee(emp); // After registering the Employee collecting the id value
	   // after registering placing want to place all the Employee in shared memory
		
		// session scope
		ses.setAttribute("resultMsg",result); // This will store the data in session scope even after page is refreshed  for n times this data
		// will remains until the sessions lost's
		
		return "redirect:report";  // here this is redirecting to report so that only once add employee method logic executes
		
	}
	
	
	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no")Integer no, @ModelAttribute("emp") Employee emp) {
		
		Employee emp1 = empServ.getEmployeeById(no); //get employee details dynamically based on the given employee No
		
		// emp = emp1
		BeanUtils.copyProperties(emp1, emp);
		
		return "employee_edit";
	}
	
	
	/*
	
	@PostMapping("/edit")
	public String editEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		
		String result = empServ.editEmployee(emp);   // updating the edited employee
		
		List<Employee> list = empServ.getAllEmployees(); // Collecting all the updated employee details into a list
		
		
		map.put("resultMsg", result); // taking the return into shared memory
		map.put("empsData", list); // placing the updated employee's data in shared memory
		
		return "employee_report";
	}
	
	*/
	
	
	@PostMapping("/edit")
	public String editEmployee(RedirectAttributes redatt, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		
		
		if(emp.getVflag().equalsIgnoreCase("no")) {
			
			//checking for type miss match errors
			if(errors.hasFieldErrors())
				return "employee_edit";
			
			// checking form validation errors
			if(emplValidator.supports(emp.getClass())) {
				emplValidator.validate(emp, errors);
				
				if(errors.hasErrors()) {
					return "employee_edit";
				}
			}
		}
		
		// application logical errors
		if(emp.getJob().equalsIgnoreCase("hacker")) {
			errors.rejectValue("job", "job.reject");
			return "employee_edit";
		}
		
		
		String result = empServ.editEmployee(emp);   // updating the edited employee
		
		
		redatt.addFlashAttribute("resultMsg",result);
		
		return "redirect:report";
	}
	
	/*
	@GetMapping("/delete")
	public String deleteEmployee(Map<String, Object> map,@RequestParam("no") Integer no) {
		
		String result = empServ.deleteEmployee(no);
		List<Employee> list = empServ.getAllEmployees();
		
		map.put("empsData", list);
		map.put("resultMsg", result);
		
		return "employee_report";
	}*/
	
	
	@GetMapping("/delete")
	public String deleteEmployee(RedirectAttributes redatt,@RequestParam("no") Integer no) {
		
		String result = empServ.deleteEmployee(no);
		
		redatt.addFlashAttribute("resultMsg", result);
		
		return "redirect:report";
	}
	

}
