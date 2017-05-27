package com.niit.onlinecollaboration.model;



import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name="FORUM_DETAIL")
public class Forum implements Serializable{
	
	private static final long serialVersionUID = 2264478909075896498L;
	@Id
	private int forumId;

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNoOfPosts() {
		return noOfPosts;
	}

	public void setNoOfPosts(int noOfPosts) {
		this.noOfPosts = noOfPosts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String forumName;

	private String description;

	private LocalDate postDate;

	private String status;

	private int noOfPosts;

	private int userId;

	private String userName;

	/*@OneToMany(mappedBy="forum", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	List<ForumPosts> forumPosts;*/


}

