package com.hrms.springjwt_job.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="job_name")
	private String jobName;
	
	@Column(name="job_salary")
	private String jobSalary;
	
	
	@Column(name="job_timing")
	private String jobTiming;
	
	@Column(name="job_description")
	private String jobDescription;
	
	
	public Job(){
		
	}
	
	public Job(String jobName, String jobSalary, String jobTiming, String jobDescription) {
		super();
		this.jobName = jobName;
		this.jobSalary = jobSalary;
		this.jobTiming = jobTiming;
		this.jobDescription = jobDescription;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobSalary() {
		return jobSalary;
	}
	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}
	public String getJobTiming() {
		return jobTiming;
	}
	public void setJobTiming(String jobTiming) {
		this.jobTiming = jobTiming;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	

}

