package com.niit.onlinecollaboration.dao;

import java.util.List;

import com.niit.onlinecollaboration.model.Job;

public interface JobDao {

	List<Job> list();
	List<Job> getJobsByStatus(String status);
	List<Job> getUserJobs(int id);
	Job getJob(int id);
	boolean addJob(Job job);
	boolean updateJob(Job job);
	boolean deleteJob(Job job);

}
