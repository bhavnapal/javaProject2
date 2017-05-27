package com.niit.onlinecollaboration.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlinecollaboration.dao.UserDao;
import com.niit.onlinecollaboration.model.User_Detail;
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(User_Detail user) {
		try {	
			
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int userId) {
		
		User_Detail user = this.getUserDetail(userId);
		user.setActive(false);
		
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(User_Detail user) {
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(user);
			System.out.println("data updated"+user.getAddress()+user.getCity()+user.getEmail()+user.getName()+user.getPassword()+user.getPhoneNo()+user.getRole()+user.getState()+user.getState()+user.getUserId());
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User_Detail getUserDetail(int userId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(User_Detail.class,Integer.valueOf(userId) );
	}

	@Override
	public List<User_Detail> userlist() {
		return sessionFactory.getCurrentSession().createQuery("FROM User_Detail WHERE active = TRUE").list();
	}
	
}
