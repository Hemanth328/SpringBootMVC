package com.org.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "emp")
@Data
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer empno;
	
	private String ename;
	private String job;
	private Long deptno;
	private Double sal;

}
