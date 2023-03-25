package com.org.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.exception.EmployeeNotFoundException;
import com.org.model.Employee;
import com.org.repo.IEmployeeRepo;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	
	@Autowired
	private IEmployeeRepo empRepo;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		 
		return empRepo.findAll();
	}
	
	
	public String registerEmployee(Employee emp) {
		int idno = empRepo.save(emp).getEmpno();
		
		return "Employee Registration Id "+idno;
	}
	
	
	public String deleteEmployee(Integer no) {
		
		empRepo.deleteById(no);
		
		return "Record "+no+" Deleted Successfully";
	}
	
	public Employee getEmployeeById(Integer no) {

		Optional<Employee> emp = empRepo.findById(no);
		
		if(emp.isEmpty())
			throw new EmployeeNotFoundException("Employee Id " +no+ " Not Found");
		
		return emp.get();
	}
	
	
	public String editEmployee(Employee emp) {
		
		return "Employee Id  "+ empRepo.save(emp).getEmpno() +" Details Updated Successfully";
	}

}
