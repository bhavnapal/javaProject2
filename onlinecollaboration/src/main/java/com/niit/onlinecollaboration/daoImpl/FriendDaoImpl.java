package com.niit.onlinecollaboration.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.onlinecollaboration.dao.FriendDao;
import com.niit.onlinecollaboration.model.Friends;

@Transactional
@Repository("friendsDao")
public class FriendDaoImpl implements FriendDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addFriend(Friends friendShip) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(friendShip);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateFriend(Friends friendShip) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(friendShip);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Friends> getFriends(Integer id) {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().createQuery("from Friends where user_userid=:id",Friends.class).setParameter("id", id).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
