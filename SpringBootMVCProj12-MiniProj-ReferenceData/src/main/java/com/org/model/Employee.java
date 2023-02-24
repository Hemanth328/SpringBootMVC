package com.org.model;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@SQLDelete(sql="UPDATE EMP SET STATUS='inactive' WHERE EMPNO=?")
@Where(clause = "STATUS <> 'inactive' ")
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
	@Column
	private String Status = "active";
	@Transient
	private String vflag = "no";
	
	private String country = "India";
	
	private String state;
}
