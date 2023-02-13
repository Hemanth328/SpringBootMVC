package com.org.model;

import lombok.Data;

@Data
public class Student {
	
	private Integer sid;
	private String sname;
	private String sadd = "Vskp";
	private Float avg; 

}
