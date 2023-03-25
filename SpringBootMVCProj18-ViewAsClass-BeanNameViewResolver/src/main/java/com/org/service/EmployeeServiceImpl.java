package com.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.model.Employee;
import com.org.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

}
