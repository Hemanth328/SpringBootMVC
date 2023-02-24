package com.org.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
		
		return empRepo.findById(no).get();
	}
	
	
	public String editEmployee(Employee emp) {
		
		return "Employee Id  "+ empRepo.save(emp).getEmpno() +" Details Updated Successfully";
	}
	
	
	@Override
	public Page<Employee> getAllEmployeesPageData(Pageable pageable) {
		
		Page<Employee> page = empRepo.findAll(pageable);
		return page;
	}
	
	@Override
	public Set<String> getAllCountries() {
		
		Locale locale[] = Locale.getAvailableLocales(); // gives all the countries list
		
		Set<String> countrySet = new TreeSet(); // collecting all the country names into Set
		
		for(Locale l: locale) {
			
			if(l != null) {
				countrySet.add(l.getDisplayCountry());
			}
		}
		
		return countrySet; 
	}
	
	
	@Autowired
	private Environment env;
	
	@Override
	public List<String> getStatesByCountry(String country) {
		
		//get states of a country through environment object
		String statesInfo = env.getRequiredProperty(country);
		
		//convert comma separated values into List collection using "," as delimeter
		List<String> statesList = Arrays.asList(statesInfo.split(","));
		
		//Sort the collection
		Collections.sort(statesList);
		return statesList;
	}

}
