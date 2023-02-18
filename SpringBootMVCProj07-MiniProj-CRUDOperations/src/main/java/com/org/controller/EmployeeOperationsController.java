package com.org.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.model.Employee;
import com.org.service.IEmployeeMgmtService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empServ;
	
	@GetMapping("/")
	public String showhome() {
		System.out.println("EmployeeOperationsController.showhome()");
		return "home";
	}
	
	
	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map) {
		List<Employee> list = empServ.getAllEmployees();
		map.put("empsData", list);
		System.out.println(list);
		return "employee_report";
	}
	
	
	@GetMapping("/add")
	public String showAddEmployeeForm(@ModelAttribute("emp") Employee emp) {  // Launching the form Employee registration form page with default Job description
		
		emp.setJob("Team Lead");
		
		return "employee_register";
	}
	
	
	
	@PostMapping("/add")
	public String addEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		
		String result = empServ.registerEmployee(emp); // After registering the Employee collecting the id value
		List<Employee> list = empServ.getAllEmployees(); // after registering placing want to place all the Employee in shared memory
		
		
		map.put("empsData", list); // placing the Data in shared memory
		map.put("resultMsg", result); // placing the result in shared memory
		
		return "employee_report";
		
	}
	
	
	
	@GetMapping("/edit")
	public String showEditEmployeeForm(@RequestParam("no")Integer no, @ModelAttribute("emp") Employee emp) {
		
		Employee emp1 = empServ.getEmployeeById(no); //get employee details dynamically based on the given employee No
		
		// emp = emp1
		BeanUtils.copyProperties(emp1, emp);
		
		return "employee_edit";
	}
	
	
	@PostMapping("/edit")
	public String editEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		
		String result = empServ.editEmployee(emp);   // updating the edited employee
		
		List<Employee> list = empServ.getAllEmployees(); // Collecting all the updated employee details into a list
		
		
		map.put("resultMsg", result); // taking the return into shared memory
		map.put("empsData", list); // placing the updated employee's data in shared memory
		
		return "employee_report";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployee(Map<String, Object> map,@RequestParam("no") Integer no) {
		
		String result = empServ.deleteEmployee(no);
		List<Employee> list = empServ.getAllEmployees();
		
		map.put("empsData", list);
		map.put("resultMsg", result);
		
		return "employee_report";
	}

}
