package com.niit.onlinecollaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.onlinecollaboration.dao.JobDao;
import com.niit.onlinecollaboration.model.Blog;
import com.niit.onlinecollaboration.model.DomainResponse;
import com.niit.onlinecollaboration.model.Forum;
import com.niit.onlinecollaboration.model.Job;

@RestController
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	private JobDao jobDao;
	
	/*mapping to get the list of jobs*/
	@RequestMapping("/all")
	public ResponseEntity<List<Job>> get(){
		return new ResponseEntity<List<Job>>(jobDao.list(),HttpStatus.OK);
	}
	
	/*mapping to get the particular job with id*/
	@RequestMapping("/get/{id}")
	public ResponseEntity<Job> get(@PathVariable int id) {
		System.out.println("-------------------------------------reached into controller--------------------------------------------");
		return new ResponseEntity<Job>(jobDao.getJob(id), HttpStatus.OK);
	}
	
	@RequestMapping("/all/{status}")
	public ResponseEntity<List<Job>> getByStatus(@PathVariable String status){
		return new ResponseEntity<List<Job>>(jobDao.getJobsByStatus(status),HttpStatus.OK);
	}
	
	/*mapping to add job to job table*/
	@PostMapping("/insert")
	public ResponseEntity<DomainResponse> post(@RequestBody Job job){
		System.out.println("-------------------------------------reached into controller1--------------------------------------------");
		jobDao.addJob(job);
		System.out.println("-------------------------------job adeed successfully--------------");
		return new ResponseEntity<DomainResponse> (new DomainResponse("job table recieved the data",100), HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<DomainResponse> updateJob(@RequestBody Job job,@PathVariable int id){
		Job currentJob = jobDao.getJob(id);
		currentJob.setCompanyName(job.getCompanyName());
		currentJob.setContactInfo(job.getContactInfo());
		currentJob.setJobId(job.getJobId());
		currentJob.setJobProfile(job.getJobProfile());
		currentJob.setQualification(job.getQualification());
		currentJob.setSubTitle(job.getSubTitle());
		jobDao.updateJob(job);
		return new ResponseEntity<DomainResponse> (new DomainResponse("job is updated",100), HttpStatus.OK);
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<DomainResponse> deleteJobById(@PathVariable int id) {
		Job job = new Job();
		job=jobDao.getJob(id);
		jobDao.deleteJob(job); 
		return new ResponseEntity<DomainResponse>(new DomainResponse("job is deleted",100), HttpStatus.OK);

	}

}
