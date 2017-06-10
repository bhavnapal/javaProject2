package com.niit.onlinecollaboration.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Friends implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer fid;
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	private User_Detail user;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	private User_Detail friend;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public User_Detail getUser() {
		return user;
	}
	public void setUser(User_Detail user) {
		this.user = user;
	}
	public User_Detail getFriend() {
		return friend;
	}
	public void setFriend(User_Detail friend) {
		this.friend = friend;
	}
	
}
