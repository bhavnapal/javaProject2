package com.niit.onlinecollaboration.dao;

import java.util.List;

import javax.xml.registry.infomodel.User;

import com.niit.onlinecollaboration.model.User_Detail;

public interface UserDao {

	
	boolean add(User_Detail user);
	boolean delete(int userId);
	boolean update(User_Detail user);
	User_Detail getUserDetail(int userId);
	List<User_Detail> userlist();
	List<User_Detail> list(String status);
	User_Detail getUserByUserName(String userName);
	User_Detail validateUser(User_Detail user);	
	boolean isOnline(User_Detail user);
	User_Detail getUserByEmail(String email);
}
