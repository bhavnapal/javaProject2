package com.niit.onlinecollaboration.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.onlinecollaboration.dao.JobDao;
import com.niit.onlinecollaboration.model.Blog;
import com.niit.onlinecollaboration.model.Job;
@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Job> list() {
		return  sessionFactory.getCurrentSession().createQuery("FROM Job").list();
	}

	@Override
	public List<Job> getJobsByStatus(String status) {
		return sessionFactory.getCurrentSession().createQuery("FROM Job where status = '" + status +"'").list();
	}

	@Override
	public List<Job> getUserJobs(int id) {
		return sessionFactory.getCurrentSession().createQuery("FROM Job where USER_ID = '" + id +"'").list();
	}

	@Override
	public Job getJob(int id) {
		return sessionFactory.getCurrentSession().get(Job.class, id);
	}

	@Override
	public boolean addJob(Job job) {
		try {			
			sessionFactory.getCurrentSession().persist(job);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		try {
			// update the category to database table
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteJob(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Job> list(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
