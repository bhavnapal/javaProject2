package com.bp.onlinecollaboration.model;

import javax.persistence.Transient;

public class DomainResponse {

	
	@Transient
	private String responseMessage;
	
	@Transient
	private int responseCode;

	public DomainResponse() {}

	public DomainResponse(String responseMessage, int responseCode) {
		super();
		this.responseMessage = responseMessage;
		this.responseCode = responseCode;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public String toString() {
		return "DomainResponse [responseMessage=" + responseMessage + ", responseCode=" + responseCode + "]";
	}
	
	
	
	
	
}
