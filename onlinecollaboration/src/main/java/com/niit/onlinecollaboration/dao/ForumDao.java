package com.niit.onlinecollaboration.dao;

import java.util.List;

import com.niit.onlinecollaboration.model.Forum;

public interface ForumDao {

	List<Forum> list();
	Forum getForum(int id);
	boolean addForum(Forum forum);
	boolean updateForum(Forum forum);
	boolean deleteForum(Forum forum);

}
