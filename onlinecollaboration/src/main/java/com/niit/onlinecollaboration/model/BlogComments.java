package com.niit.onlinecollaboration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BlogComments implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer cmtId;
	@ManyToOne
	private Blog blog;
	@ManyToOne
	private User_Detail users;
	private String blogComment;
	public Integer getCmtId() {
		return cmtId;
	}
	public void setCmtId(Integer cmtId) {
		this.cmtId = cmtId;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public User_Detail getUsers() {
		return users;
	}
	public void setUsers(User_Detail users) {
		this.users = users;
	}
	public String getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
}
