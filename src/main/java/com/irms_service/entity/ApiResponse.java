package com.irms_service.entity;

import com.irms_service.Constants;

public class ApiResponse {

	Object body;

	String statusMessage;
	
	public ApiResponse() {}
	
	public ApiResponse(Object body) {
		this.body = body;
		this.statusMessage = Constants.VALUE_SUCCESS;
	}
	
	public ApiResponse(Object body, String msg) {
		this.body = body;
		this.statusMessage = msg;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	

}
