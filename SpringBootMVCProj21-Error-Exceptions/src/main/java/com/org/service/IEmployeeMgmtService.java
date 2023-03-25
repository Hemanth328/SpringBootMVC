package com.org.service;

import java.util.List;

import com.org.model.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> getAllEmployees();
	
	public String registerEmployee(Employee emp);
	
	public Employee getEmployeeById(Integer no);
	
	public String editEmployee(Employee emp);
	
	public String deleteEmployee(Integer no);
}
