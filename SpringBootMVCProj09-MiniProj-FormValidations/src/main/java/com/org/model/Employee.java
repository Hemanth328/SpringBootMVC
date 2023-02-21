package com.org.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="emp")
@Data
public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName="emp_id_seq")
	@GeneratedValue(generator="gen1", strategy= GenerationType.SEQUENCE)
	private Integer empno;
	
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private String job;
	@Column
	private Float sal;
	@Transient
	private String vflag = "no";
}
