package com.org.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
