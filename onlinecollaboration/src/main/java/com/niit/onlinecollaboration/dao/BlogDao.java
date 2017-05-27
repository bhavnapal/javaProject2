package com.niit.onlinecollaboration.dao;

import java.util.List;

import com.niit.onlinecollaboration.model.Blog;

public interface BlogDao {

	
	List<Blog> list();
	List<Blog> getBlogsByStatus(String status);
	List<Blog> getUsersBlogs(int id);
	Blog getBlog(int id);
	boolean addBlog(Blog blog);
	boolean updateBlog(Blog blog);
	boolean deleteBlog(Blog blog);
	
}
