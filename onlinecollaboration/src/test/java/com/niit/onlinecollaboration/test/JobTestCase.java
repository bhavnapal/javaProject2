package com.niit.onlinecollaboration.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinecollaboration.dao.JobDao;
import com.niit.onlinecollaboration.model.Job;

public class JobTestCase {

	private static AnnotationConfigApplicationContext context;
	private static JobDao jobDao;
	private Job job;
	
	@BeforeClass
	public static void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.onlinecollaboration");
	context.refresh();
	
	jobDao = (JobDao)context.getBean("jobDao");
	}
	
	/*
	 * test case to add a job in table
	 * */
	
	@Test
	public void testAddServices(){
		job = new Job();
		
		job.setJobId(1);
		job.setCompanyName("techZealot");
	    job.setSubTitle("openings for software engineers");
		job.setJobProfile("software engineer");
		job.setQualification("b.tech with cse/ece");
		job.setContactInfo("9970397093");
		
		assertEquals("Successfully added a product inside the table!",true,jobDao.addJob(job));
	}
	
	/**
	 * test case to get single data from job table
	 * */
	
	/*@Test
	public void testGetServices(){
		job = new Job();
		job = jobDao.getJob(1);
		assertEquals("Successfully fetched a single category from the table!","techZealot",job.getCompanyName());
	}*/
	
	/**
	 * test case to update data into job table
	 * */
	
	/*@Test
	public void testUpdateServices(){
		job = new Job();
		job = jobDao.getJob(1);
		
		job.setContactInfo("9890093846");
		
		assertEquals("Successfully update a single category in the table!",true,jobDao.updateJob(job));
	}*/
	
	/**
	 * test case to delete data from job table
	 * */
	
	/*@Test
	public void testDeletServices(){
		job = new Job();
		job = jobDao.getJob(1);
		assertEquals("Successfully delete a single category in the table!",true,jobDao.deleteJob(job));
	}*/
	
	/**
	 * test case to get list from job table
	 * **/
	
	/*@Test
	public void testListServices(){
		
		assertEquals("Successfully fetched a list of services from the table!",1,jobDao.list().size());
	}*/
}
