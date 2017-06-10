package com.niit.onlinecollaboration.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlinecollaboration.dao.BlogDao;
import com.niit.onlinecollaboration.model.Blog;
@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Blog> list() {
		return  sessionFactory.getCurrentSession().createQuery("FROM Blog").list();
	}

	@Override
	public List<Blog> getBlogsByStatus(String status) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Blog where status = '" + status +"'").list();
	}

	@Override
	public List<Blog> getUsersBlogs(int id) {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Blog where USER_ID = '" + id +"'").list();
	}

	@Override
	public Blog getBlog(int id) {
		return sessionFactory.getCurrentSession().get(Blog.class, id);
	
	}

	@Override
	public boolean addBlog(Blog blog) {
		try {			
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	

	

}
