package com.niit.onlinecollaboration.daoImpl;

import java.util.List;

import javax.xml.registry.infomodel.User;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

			sessionFactory.getCurrentSession().save(user);
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
			System.out.println("data updated" + user.getAddress() + user.getCity() + user.getEmail() + user.getName()
					+ user.getPassword() + user.getPhoneNo() + user.getRole() + user.getState() + user.getState()
					+ user.getUserId());

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public User_Detail getUserDetail(int userId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(User_Detail.class, Integer.valueOf(userId));
	}

	@Override
	public List<User_Detail> userlist() {
		return sessionFactory.getCurrentSession().createQuery("FROM User_Detail WHERE active = TRUE").getResultList();
	}

	@Override
	public User_Detail getUserByUserName(String userName) {
		try {
			return sessionFactory.getCurrentSession().createQuery("FROM User_Detail WHERE userName=:username",User_Detail.class).setParameter("username",userName).getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public User_Detail validateUser(User_Detail user) {

		String username = user.getUserName();
		String password = user.getPassword();

		String hql = "FROM User_Detail where userName = '" + username + "' and password = '" + password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		try {
			user = (User_Detail) query.getSingleResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isOnline(User_Detail user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<User_Detail> list(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User_Detail getUserByEmail(String email) {
		try{
			System.out.println(" email in get user by mail method"+email);
		return	sessionFactory.getCurrentSession().createQuery("From User_Detail where email=:email",User_Detail.class).setParameter("email", email).getSingleResult();
		}catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		
	}

}
