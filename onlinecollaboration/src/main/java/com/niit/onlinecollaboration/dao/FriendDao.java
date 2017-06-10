package com.niit.onlinecollaboration.dao;

import java.util.List;

import com.niit.onlinecollaboration.model.Friends;

public interface FriendDao {
	boolean addFriend(Friends friends);
	boolean updateFriend(Friends friends);
	List<Friends> getFriends(Integer id); 
}
