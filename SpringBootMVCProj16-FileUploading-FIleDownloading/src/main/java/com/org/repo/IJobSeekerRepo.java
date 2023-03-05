package com.org.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.JobSeekerInfo;

public interface IJobSeekerRepo extends JpaRepository<JobSeekerInfo, Integer>{

}
