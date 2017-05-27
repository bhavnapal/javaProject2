package com.niit.onlinecollaboration.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinecollaboration.dao.BlogDao;
import com.niit.onlinecollaboration.model.Blog;

public class BlogTestCase {

	private static AnnotationConfigApplicationContext context;
	private static BlogDao blogDao;
	private Blog blog;
	
	@BeforeClass
	public static void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.onlinecollaboration");
	context.refresh();
	
	blogDao = (BlogDao)context.getBean("blogDao");
	}
	
	/*
	 * test case to add a blog in table
	 * */
	
	@Test
	public void testAddServices(){
		blog = new Blog();
		
		blog.setBlogId(1);
		blog.setBlogName("techZealot");
	    blog.setBlogDescription("for technical skills");
		blog.setBlogStatus("approved");
		blog.setNoOfComments(10);
		blog.setNoOfLikes(10);
		blog.setNoOfViews(12);
		blog.setPostDate(LocalDate.parse("2017-04-21"));
		blog.setUserId(1);
		blog.setUserName("bhavna");
		
		assertEquals("Successfully added a product inside the table!",true,blogDao.addBlog(blog));
	}
	
	/**
	 * test case to get single data from blog table
	 * */
	
	/*@Test
	public void testGetServices(){
		blog = new Blog();
		blog = blogDao.getBlog(1);
		assertEquals("Successfully fetched a single category from the table!","techZealot",blog.getBlogName());
	}*/
	
	/**
	 * test case to update data into blog table
	 * */
	
	/*@Test
	public void testUpdateServices(){
		blog = new Blog();
		blog = blogDao.getBlog(1);
		blog.setBlogStatus("rejected");;
		
		assertEquals("Successfully update a single category in the table!",true,blogDao.updateBlog(blog));
	}*/
	
	/**
	 * test case to delete data from blog table
	 * */
	
	/*@Test
	public void testDeletServices(){
		blog = new Blog();
		blog = blogDao.getBlog(1);
		assertEquals("Successfully delete a single category in the table!",true,blogDao.deleteBlog(blog));
	}*/
	
	/**
	 * test case to get list from blog table
	 * */
	
	/*@Test
	public void testListServices(){
		
		assertEquals("Successfully fetched a list of services from the table!",1,blogDao.list().size());
	}*/
}
