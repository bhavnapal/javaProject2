package com.niit.onlinecollaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.onlinecollaboration.dao.UserDao;
import com.niit.onlinecollaboration.model.DomainResponse;
import com.niit.onlinecollaboration.model.User_Detail;
import com.niit.onlinecollaboration.service.EmailService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	EmailService emailService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ResponseEntity<User_Detail> validateUser(@RequestBody User_Detail user) {
		System.out.println(user);

		if (user.getUserName() != null && user.getPassword() != null) {
			System.out.println(user.getUserName());
			if (userDao.validateUser(user) == null) {
				user = new User_Detail();

				System.out.println("Invalid Credentials");
				return new ResponseEntity<User_Detail>(user, HttpStatus.NO_CONTENT);
			} else {
				user = userDao.getUserByUserName(user.getUserName());
				System.out.println("This is in elser::::"+user);
				Boolean status = Boolean.valueOf("true");
				user.setIsOnline(true);

				System.out.println("Login Successful!");
				userDao.update(user);
				return new ResponseEntity<User_Detail>(user, HttpStatus.OK);
			}

		} else {
			user = new User_Detail();
			return new ResponseEntity<User_Detail>(user, HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public ResponseEntity<Void> toLogout(@RequestBody User_Detail user) {

		user.setIsOnline(false);
		userDao.update(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/get/{id}")
	public ResponseEntity<User_Detail> getUserById(@PathVariable int id) {

		return new ResponseEntity<User_Detail>(userDao.getUserDetail(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<DomainResponse> post(@RequestBody User_Detail user) {

		userDao.add(user);
		user=userDao.getUserByEmail(user.getEmail());
		//emailService.approvedUserMessage(user.getEmail());
		return new ResponseEntity<DomainResponse>(new DomainResponse("user recieved the data", 100), HttpStatus.OK);
	}

	@RequestMapping("/all")
	public ResponseEntity<List<User_Detail>> getList() {
		return new ResponseEntity<List<User_Detail>>(userDao.userlist(), HttpStatus.OK);
	}

	@RequestMapping("/delete/{id}")
	public ResponseEntity<DomainResponse> deleteUserById(@PathVariable int id) {
		userDao.delete(id);
		return new ResponseEntity<DomainResponse>(new DomainResponse("deleted the data", 100), HttpStatus.OK);

	}

	@PostMapping("/update/{id}")
	public ResponseEntity<DomainResponse> updateUser(@RequestBody User_Detail user, @PathVariable int id) {

		User_Detail currentUser = userDao.getUserDetail(id);
		currentUser.setUserId(user.getUserId());
		currentUser.setAddress(user.getAddress());
		currentUser.setActive(user.isActive());
		currentUser.setCity(user.getCity());
		currentUser.setEmail(user.getEmail());
		currentUser.setGender(user.getGender());
		currentUser.setIsOnline(user.getIsOnline());
		currentUser.setName(user.getName());
		currentUser.setPassword(user.getPassword());
		currentUser.setPhoneNo(user.getPhoneNo());
		
		currentUser.setRole(user.getRole());
		currentUser.setState(user.getState());
		currentUser.setUserName(user.getUserName());
		
		userDao.update(currentUser);

		return new ResponseEntity<DomainResponse>(new DomainResponse("user recieved the data", 100), HttpStatus.OK);
	}
}
