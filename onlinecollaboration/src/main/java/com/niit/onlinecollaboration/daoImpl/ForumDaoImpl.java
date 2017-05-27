package com.niit.onlinecollaboration.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlinecollaboration.dao.ForumDao;
import com.niit.onlinecollaboration.model.Blog;
import com.niit.onlinecollaboration.model.Forum;
@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Forum> list() {
		return  sessionFactory.getCurrentSession().createQuery("FROM Forum").list();
	}

	@Override
	public Forum getForum(int id) {
		return sessionFactory.getCurrentSession().get(Forum.class, id);
	}

	@Override
	public boolean addForum(Forum forum) {
		try {			
			sessionFactory.getCurrentSession().persist(forum);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
