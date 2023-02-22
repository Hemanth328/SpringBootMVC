package com.org.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.org.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(Employee.class); // Checks whether we are passing correct model class or not)
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		System.out.println("EmployeeValidator.validate() (Server side form validations)");
		
		// type casting
		Employee emp = (Employee)target;
		
		// form validation logics
		
		
		// required rule ename
		
		if(emp.getEname() == null || emp.getEname().length() == 0 || emp.getEname().equals("")) {
			errors.rejectValue("ename", "empname.required");
		}
		else if(emp.getEname().length() > 20) {
			errors.rejectValue("ename", "empname.maxlength");
		}
		
		
		// required rule job
		
		if(emp.getJob() == null || emp.getJob().length() == 0 || emp.getJob().equals("")) {
			errors.rejectValue("ename", "empdesg.required");
		}
		else if(emp.getJob().length() > 15) {
			errors.rejectValue("ename", "empdesg.maxlength");
		}
		
		
		// required rule sal
		
		if(emp.getSal() == null) {
			errors.rejectValue("ename", "empsal.required");
		}
		else if(emp.getSal() < 1 || emp.getSal() > 1000000 )  {
			errors.rejectValue("ename", "empsal.range");
		}	
		
	}

}
