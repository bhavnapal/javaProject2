package com.niit.onlinecollaboration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.onlinecollaboration.model.DomainResponse;

@RestController
public class GreetingController {

	
	
	@RequestMapping(value="/greeting")
	public ResponseEntity<DomainResponse> greeting(){
		
		return new ResponseEntity<DomainResponse>(new DomainResponse("welcome from spring rest controller",200),HttpStatus.OK); 
	}
	}

