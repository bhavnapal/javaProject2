package com.niit.onlinecollaboration.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.onlinecollaboration.dao.BlogCommentsDao;
import com.niit.onlinecollaboration.model.BlogComments;

@Transactional
@Repository("blogCommentsDao")
public class BlogCommentsDaoImpl implements BlogCommentsDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean postComment(BlogComments blogComment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<BlogComments> allComments(Integer blogId) {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().createQuery("From BlogComments where BLOG_BLOGID=:id",BlogComments.class).setParameter("id", blogId).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

}
