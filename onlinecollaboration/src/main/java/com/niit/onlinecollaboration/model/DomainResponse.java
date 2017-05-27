package com.niit.onlinecollaboration.model;

public class DomainResponse {
private String ResponseMessage;
private int ResponseCode;




public DomainResponse(String responseMessage, int responseCode) {
	super();
	this.ResponseMessage = responseMessage;
	this.ResponseCode = responseCode;
}
public String getResponseMessage() {
	return ResponseMessage;
}
public void setResponseMessage(String responseMessage) {
	ResponseMessage = responseMessage;
}
public int getResponseCode() {
	return ResponseCode;
}
public void setResponseCode(int responseCode) {
	ResponseCode = responseCode;
}
}
