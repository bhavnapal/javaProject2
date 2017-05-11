package com.bp.onlinecollaboration.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bp.onlinecollaboration.dao.UserDAO;
import com.bp.onlinecollaboration.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired 
	User user;

	public List<User> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM User", User.class).getResultList();
	}

	@Override
	public boolean add(User user) {
		try {
			// adding product to database
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(User user) {
		try {
			// deleting product to database
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByUserName(String userName) {
		String get="FROM User where userName =: userName";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(get);
		query.setParameter("userName",userName);
		try{
			return (User) query.getSingleResult();
		}
		catch(Exception e){
			return null;
		}
	}
	@Transactional
	public User validate(User user){
		String username = user.getUserName();
		String password = user.getPassword();
		String get = "from User where username = '" +username+"' and password = '"+password+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(get);
		try {
			user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public User getById(int userId) {
		
		return (User) sessionFactory.getCurrentSession().get(User.class, userId);
	}
}
