package com.org.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name="JS_INFO")
public class JobSeekerInfo implements Serializable{

	@Id
	@GeneratedValue
	private Integer jsId;
	@Column(length = 25)
	private String jsName;
	@Column(length = 25)
	private String jsAddrs;
	@Column(length = 250)
	private String resumePath;
	@Column(length=250)
	private String photoPath;
	
}
