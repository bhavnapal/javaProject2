package com.niit.onlinecollaboration.dao;

import java.util.List;

import com.niit.onlinecollaboration.model.BlogComments;

public interface BlogCommentsDao {
	boolean postComment(BlogComments blogComment);
	List<BlogComments> allComments(Integer blogId);
}
