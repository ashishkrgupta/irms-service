package com.irms_service;

public class CustomResponseBody {

	Object response;

	String errorMessage;
	
	public CustomResponseBody(Object response) {
		super();
		this.response = response;
	}
	
	public CustomResponseBody(Object response, String errorMessage) {
		super();
		this.response = response;
		this.errorMessage = errorMessage;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
