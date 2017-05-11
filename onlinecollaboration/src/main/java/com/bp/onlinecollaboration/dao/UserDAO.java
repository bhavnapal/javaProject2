package com.bp.onlinecollaboration.dao;

import java.util.List;

import com.bp.onlinecollaboration.model.User;

public interface UserDAO {

		public boolean add(User user);

		public boolean delete(User user);
		
		public User getByUserName(String userName);
		
		public User getById(int userId);
		
		public List<User> list();

		public User validate(User user);
		
		/*public List<User> getUsersByStatus(String status);
		
		boolean updateUserProfileId(String fileName, int userId);
		
		List<User> getTopUsers(int n);*/
	
}
