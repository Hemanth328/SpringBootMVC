package com.org.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.org.entity.JobSeekerInfo;
import com.org.model.JobSeekerData;
import com.org.service.IJobSeekerMgmtService;

@Controller
public class JobSeekerOpeartionsController {
	
	@Autowired
	private IJobSeekerMgmtService service;
	
	@GetMapping("/")
	public  String showHomePage() {
		System.out.println("JobSeekerOperationsController.showHomePage()");
		return  "welcome";
	}
	
	@GetMapping("/register")
	public   String  showJSRegistrationForm(@ModelAttribute("js") JobSeekerData jsData) {
		System.out.println("JobSeekerOpeartionsController.showJSRegistrationForm()");
		//return LVN
		return "jobseeker_register";
	}
	
	
	@Autowired
	private Environment env;
	
	@PostMapping("/register")
	public String registerJSByUploadingFiles(@ModelAttribute("js") JobSeekerData jsData, Map<String, Object> map)throws Exception {
		
		//get Upload folder location from properties file
		String storeLocation = env.getProperty("upload.store");
		
		//if that is not available then create it
		File file = new File(storeLocation);
		
		if(!file.exists())
			file.mkdir();
		
		//get InputStream representing the upload files content
		MultipartFile resumeFile = jsData.getResume();
		MultipartFile photoFile = jsData.getPhoto();
		InputStream isResume = resumeFile.getInputStream();
		InputStream isPhoto = photoFile.getInputStream();
		
		//get the names of the uploaded files
		String resumeFileName = resumeFile.getOriginalFilename();
		String photoFileName = photoFile.getOriginalFilename();
		
		
		//create outstreams representing empty destination files
		OutputStream osResume = new FileOutputStream(file.getAbsolutePath()+"\\"+resumeFileName);
		OutputStream osPhoto = new FileOutputStream(file.getAbsolutePath()+"\\"+photoFileName);
		
		
		//perform file copy operations
		IOUtils.copy(isResume, osResume);
		IOUtils.copy(isPhoto, osPhoto);
		
		
		//close Stream
		isResume.close();
		osResume.close();
		isPhoto.close();
		osPhoto.close();
		
		//prepare Entity class obj from Model class obj
		JobSeekerInfo jsInfo = new JobSeekerInfo();
		jsInfo.setJsName(jsData.getJsName());
		jsInfo.setJsAddrs(jsData.getJsAddrs());
		jsInfo.setResumePath(file.getAbsolutePath()+"\\"+resumeFileName);
		jsInfo.setPhotoPath(file.getAbsolutePath()+"\\"+photoFileName);
		
		//use Service
		String msg = service.registerJobSeeker(jsInfo);
		
		//placing the uploaded file names and location in model attributes
		map.put("file", resumeFileName);
		map.put("file2", photoFileName);
		
		// return LVN
		return "show_result";
		
	}

}
