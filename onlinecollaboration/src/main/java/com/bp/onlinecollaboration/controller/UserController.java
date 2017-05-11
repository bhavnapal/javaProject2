package com.bp.onlinecollaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bp.onlinecollaboration.dao.UserDAO;
import com.bp.onlinecollaboration.model.User;

@RestController
public class UserController {
	
	@Autowired
	User user;

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userDAO.list();
		if (users.isEmpty()) {
			user = new User();
			System.out.println("No Users present.");
			users.add(user);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") int userId) {
		System.out.println("Fetching User");
		User user = userDAO.getById(userId);
		if (user == null) {
			user = new User();
			System.out.println("User does not exist.");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User currentUser) {

		user = userDAO.getByUserName(currentUser.getUserName());
		if (user == null) {
			currentUser.setStatus("PENDING");
			currentUser.setEnabled("TRUE");
			
			if (userDAO.add(currentUser) == false) {
				user = new User();
				System.out.println("Failed to register. Please try again.");
			} else {
				user = userDAO.getByUserName(currentUser.getUserName());
				System.out.println("You are registered successfully.");
			}

		} else {
			user = new User();
			System.out.println("User already present with this username.");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") int userId, @RequestBody User updatedUser) {
		user = userDAO.getById(userId);
		if (user == null) {
			user = new User();
			System.out.println("Invalid username");
		} else {

			user.setFirstName(updatedUser.getFirstName());
			if (userDAO.add(user) == false) {
				user = new User();
				System.out.println("Failed to update profile.");
			} else {
				System.out.println("You are updated successfully.");
			}

		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> validateUser(@RequestBody User currentUser) {
		user.setUserName(currentUser.getUserName());
		user.setPassword(currentUser.getPassword());
		user = userDAO.validate(user);
		if (user == null) {
			user = new User();
			
		} else {
			user = userDAO.getByUserName(currentUser.getUserName());
			
			user.setEnabled("TRUE");
			userDAO.add(user);
			user = userDAO.getByUserName(currentUser.getUserName());
			
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logout/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> logout(@PathVariable("id") int userId) {
		user = userDAO.getById(userId);
		if (user == null) {
			user = new User();
			
		} else {

			
			if (userDAO.add(user) == false) {
				user = new User();
				
			} else {
				System.out.println("You are logout successfully.");
			}

		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

	
	/*@Autowired 
	UserDAO userDAO;
		
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		System.out.println(user);
		userDAO.add(user);
		user.setResponseMessage("You have successfully posted d data to the server");
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	// LIST USERS 
		@GetMapping("/listUsers")
		public ResponseEntity<List<User>> listUsers() {
			List<User> users = userDAO.listUsers();
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
}*/