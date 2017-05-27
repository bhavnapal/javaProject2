package com.niit.onlinecollaboration.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinecollaboration.dao.ForumDao;
import com.niit.onlinecollaboration.model.Forum;

public class ForumTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ForumDao forumDao;
	private Forum forum;
	
	@BeforeClass
	public static void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.onlinecollaboration");
	context.refresh();
	
	forumDao = (ForumDao)context.getBean("forumDao");
	}
	
	/*
	 * test case to add a forum in table
	 * */
	
	@Test
	public void testAddServices(){
		forum = new Forum();
		
		forum.setForumId(1);
		forum.setForumName("whatsApp");
	    forum.setDescription("to chat with each other");
		forum.setNoOfPosts(10);
		forum.setPostDate(LocalDate.parse("2017-04-21"));
		forum.setStatus("approved");
		forum.setUserId(1);
		forum.setUserName("bhavna");
		
		assertEquals("Successfully added a product inside the table!",true,forumDao.addForum(forum));
	}
	
	/**
	 * test case to get single data from forum table
	 * */
	
	/*@Test
	public void testGetServices(){
		forum = new Forum();
		forum = forumDao.getForum(1);
		assertEquals("Successfully fetched a single category from the table!","whatsApp",forum.getForumName());
	}*/
	
	/**
	 * test case to update data into forum table
	 * */
	
	/*@Test
	public void testUpdateServices(){
		forum = new Forum();
		forum = forumDao.getForum(1);
		
		forum.setStatus("rejected");
		
		assertEquals("Successfully update a single category in the table!",true,forumDao.updateForum(forum));
	}*/
	
	/**
	 * test case to delete data from forum table
	 * */
	
	/*@Test
	public void testDeletServices(){
		forum = new Forum();
		forum = forumDao.getForum(1);
		assertEquals("Successfully delete a single category in the table!",true,forumDao.deleteForum(forum));
	}*/
	
	/**
	 * test case to get list from forum table
	 * */
	
	/*@Test
	public void testListServices(){
		
		assertEquals("Successfully fetched a list of services from the table!",1,forumDao.list().size());
	}*/
	
}
