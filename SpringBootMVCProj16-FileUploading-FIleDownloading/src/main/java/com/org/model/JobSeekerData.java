package com.org.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeekerData {

	private Integer jsId;
	private String jsName;
	private String jsAddrs;
	private MultipartFile resume;  // Input stream to hold the content of uploaded file
	private MultipartFile photo;
}
