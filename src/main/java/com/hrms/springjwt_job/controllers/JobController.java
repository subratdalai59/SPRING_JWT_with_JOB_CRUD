package com.hrms.springjwt_job.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.springjwt_job.exception.ResourceNotFoundException;
import com.hrms.springjwt_job.models.Job;
import com.hrms.springjwt_job.repository.JobRepository;





@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api/auth/")
public class JobController {
	
	@Autowired
	private JobRepository jobRepository ;
	
	//Get All job Data
	
	@GetMapping("/jobs")
	public List<Job> getAllJobs(){
		return jobRepository.findAll();
		
	}
	
	//Create Job Rest API
	@PostMapping("/jobs")
	public Job createJob (@RequestBody Job job) {
		return jobRepository.save(job);
	}
	
	//Get Job by id REST api
	@GetMapping("/jobs/{id}")
	public ResponseEntity <Job> getJobById(@PathVariable Long id) {
		Job job=jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException	("vaccancy not exist with id :"+id));
		return ResponseEntity.ok(job);
	}
	
	//update job rest api
	@PutMapping("/jobs/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job jobDetails){
		Job job=jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException	("Vaccancy not exist with id :"+id));
		
		job.setJobName(jobDetails.getJobName());
		job.setJobSalary(jobDetails.getJobSalary());
		job.setJobTiming(jobDetails.getJobTiming());
		job.setJobDescription(jobDetails.getJobDescription());
		
		Job updatedJob =jobRepository.save(job);
		return ResponseEntity.ok(updatedJob);
	}
	//Delete Jobs under syllabus
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteJob(@PathVariable Long id){
		Job job=jobRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException	("Vaccancy not exist with id :"+id));
		
		
		jobRepository.delete(job);
		Map<String, Boolean> response =new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	
	}
	}
