package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.JobSeekerInfo;
import com.org.repo.IJobSeekerRepo;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {

	@Autowired
	private IJobSeekerRepo jsRepo;
	
	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		
		return "Job seeker is saved with "+jsRepo.save(info).getJsId()+" Id value";
	}

}
