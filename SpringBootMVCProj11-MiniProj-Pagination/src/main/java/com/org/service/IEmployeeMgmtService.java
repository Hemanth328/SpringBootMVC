package com.org.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.org.model.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> getAllEmployees();
	
	public Page<Employee> getAllEmployeesPageData(Pageable pageable);
	
	public String registerEmployee(Employee emp);
	
	public Employee getEmployeeById(Integer no);
	
	public String editEmployee(Employee emp);
	
	public String deleteEmployee(Integer no);
}
