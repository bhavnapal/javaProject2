package com.bp.onlinecollaboration.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bp.onlinecollaboration.dao.UserDAO;
import com.bp.onlinecollaboration.model.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;

	private User user;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.bp");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test	
	public void testAddUser() {
		user = new User();
		//	user.setId(1);
		user.setUserName("akhtarkhan");
		user.setFirstName("akhtar");
		user.setLastName("khan");
		user.setPassword("123");
		user.setEmail("akki@niit.com");
		user.setRole("ADMIN");
		user.setStatus("A");

			
		System.out.println("User added ");

		assertEquals("Successfully added a user inside a table", true, userDAO.add(user));
	}

}
