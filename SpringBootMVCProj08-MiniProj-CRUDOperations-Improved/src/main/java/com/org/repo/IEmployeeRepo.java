package com.org.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
