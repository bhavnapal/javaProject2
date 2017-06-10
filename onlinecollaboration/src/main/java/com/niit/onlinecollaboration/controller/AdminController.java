package com.niit.onlinecollaboration.controller;

import java.util.List;

import javax.xml.registry.infomodel.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.onlinecollaboration.dao.BlogDao;
import com.niit.onlinecollaboration.dao.JobDao;
import com.niit.onlinecollaboration.dao.UserDao;
import com.niit.onlinecollaboration.model.Blog;
import com.niit.onlinecollaboration.model.Job;
import com.niit.onlinecollaboration.model.User_Detail;

@RestController
public class AdminController {
	
	@Autowired
	UserDao userDAO;
	
	@Autowired
	BlogDao blogDAO;
	
	@Autowired
	JobDao jobDAO;
	
	@Autowired
	//EventsDao eventsDAO;
	
	
		//Method for fetching approved user list by status
		@RequestMapping(value = {"/user/manage/list"}, method = RequestMethod.GET)
		public ResponseEntity<List<User_Detail>> fetchApprovedUsers() {
				System.out.println("fetching list of approved users");
				List<User_Detail> user = userDAO.list("APPROVED");
				return new ResponseEntity<List<User_Detail>>(user, HttpStatus.OK);
		}
		
		//Method for fetching approved blog list by status
		@RequestMapping(value = {"/blog/manage/list"}, method = RequestMethod.GET)
		public ResponseEntity<List<Blog>> fetchApprovedBlogs() {
				System.out.println("fetching list of approved blogs");
				List<Blog> blog = blogDAO.getBlogsByStatus("APPROVED");
				return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
		}
		
		//Method for fetching approved jobs list by status
		@RequestMapping(value = {"/job/manage/list"}, method = RequestMethod.GET)
		public ResponseEntity<List<Job>> fetchApprovedJobs() {
				System.out.println("fetching list of approved jobs");
				List<Job> job = jobDAO.list("APPROVED");
				return new ResponseEntity<List<Job>>(job, HttpStatus.OK);
		}
		
		//Method for changing user role
		@RequestMapping(value = {"/user/role/manage"}, method = RequestMethod.POST)
		public ResponseEntity<User_Detail> changeUserRole(@RequestBody User_Detail user) {
				System.out.println("changing user role");
				userDAO.update(user);
				return new ResponseEntity<User_Detail>(user, HttpStatus.OK);
				}
		
		//Method for fetching approved event list by status
		/*@RequestMapping(value = {"/event/manage/list"}, method = RequestMethod.GET)
		public ResponseEntity<List<Events>> fetchApprovedEvents() {
				System.out.println("fetching list of approved events");
				List<Events> events = eventsDAO.getEventsByStatus("APPROVED");
						return new ResponseEntity<List<Events>>(events, HttpStatus.OK);
				}*/
		
		
}
