package com.niit.onlinecollaboration.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.onlinecollaboration.config.RootConfig;
import com.niit.onlinecollaboration.dao.UserDao;
import com.niit.onlinecollaboration.model.User_Detail;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User_Detail user;
	
	@BeforeClass
	public static void init(){
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.onlinecollaboration");
	context.refresh();
	
	userDao = (UserDao)context.getBean("userDao");
	
	}
	
	
	@Test
	public void testAddServices(){
		user = new User_Detail();
		
		user.setAddress("mumbai");
		user.setUserId(1);
	    user.setState("maharashtra");
		user.setCity("mumbai");
		user.setEmail("bhavnapal1995@gmail.com");
		user.setName("bhavna");
		user.setPassword("12345");
		user.setPhoneNo("9891");
		user.setActive(true);
		user.setRole("Staff");
		user.setIsOnline("Staff");
		user.setUserName("Staff");
		user.setGender('f');
		user.setStatus("approved");
		user.setProfile("bhavna");
		user.setBirthDate(LocalDate.parse("1995-05-01"));
		assertEquals("Successfully added a product inside the table!",true,userDao.add(user));
	}
	
	/*@Test
	public void testGetServices(){
		user = new User_Detail();
		user = userDao.getUserDetail(1);
		assertEquals("Successfully fetched a single category from the table!","bhavna",user.getName());
	}*/
	
	/*@Test
	public void testUpdateServices(){
		user = new User_Detail();
		user = userDao.getUserDetail(1);
		
		user.setCity("kalyan");
		
		assertEquals("Successfully update a single category in the table!",true,userDao.update(user));
}*/
	
	/*@Test
	public void testDeletServices(){
		
		
		assertEquals("Successfully delete a single category in the table!",true,userDao.delete(9));
}*/
	
	/*@Test
	public void testListServices(){
		
		assertEquals("Successfully fetched a list of services from the table!",1,userDao.userlist().size());
	}*/
	
}

	

