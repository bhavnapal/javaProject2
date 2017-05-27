package com.niit.onlinecollaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.onlinecollaboration.dao.ForumDao;
import com.niit.onlinecollaboration.model.Blog;
import com.niit.onlinecollaboration.model.DomainResponse;
import com.niit.onlinecollaboration.model.Forum;

@RestController
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	private ForumDao forumDao;
	
	/*mapping to get the list of forum*/
	@RequestMapping("/all")
	public ResponseEntity<List<Forum>> get(){
		return new ResponseEntity<List<Forum>>(forumDao.list(),HttpStatus.OK);
	}
	
	/*@RequestMapping("/all/{status}")
	public ResponseEntity<List<Blog>> getByStatus(@PathVariable String status){
		return new ResponseEntity<List<Blog>>(forumDao.getForumByStatus(status),HttpStatus.OK);
	}*/
	
	/*mapping to get the particular forum with id*/
	@RequestMapping("/get/{id}")
	public ResponseEntity<Forum> get(@PathVariable int id) {
		System.out.println("-------------------------------------reached into controller--------------------------------------------");
		return new ResponseEntity<Forum>(forumDao.getForum(id), HttpStatus.OK);
	}
	
	/*mapping to add forum to forum table*/
	@PostMapping("/insert")
	public ResponseEntity<DomainResponse> post(@RequestBody Forum forum){
		System.out.println("-------------------------------------reached into controller1--------------------------------------------");
		forumDao.addForum(forum);
		System.out.println("-------------------------------job adeed successfully--------------");
		return new ResponseEntity<DomainResponse> (new DomainResponse("forum table recieved the data",100), HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<DomainResponse> updateForum(@RequestBody Forum forum,@PathVariable int id){
		Forum currentForum = forumDao.getForum(id);
		currentForum.setForumId(forum.getForumId());
		currentForum.setForumName(forum.getForumName());
		currentForum.setDescription(forum.getDescription());
		currentForum.setNoOfPosts(forum.getNoOfPosts());
		currentForum.setPostDate(forum.getPostDate());
		currentForum.setStatus(forum.getStatus());
		currentForum.setUserId(forum.getUserId());
		currentForum.setUserName(forum.getUserName());
		forumDao.updateForum(currentForum);
		return new ResponseEntity<DomainResponse> (new DomainResponse("forum is updated",100), HttpStatus.OK);
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseEntity<DomainResponse> deleteForumById(@PathVariable int id) {
		Forum forum = new Forum();
		forum=forumDao.getForum(id);
		forumDao.deleteForum(forum); 
		return new ResponseEntity<DomainResponse>(new DomainResponse("forum is deleted",100), HttpStatus.OK);

	}
}
