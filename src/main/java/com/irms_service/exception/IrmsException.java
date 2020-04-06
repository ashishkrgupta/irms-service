package com.irms_service.exception;

import org.springframework.http.HttpStatus;

public class IrmsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private HttpStatus statusCode;
	
	private String statusMessage;

	public IrmsException(HttpStatus statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public IrmsException(HttpStatus statusCode, String statusMessage, Throwable cause) {
		super(cause);
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public HttpStatus getStatusCode() {
		return this.statusCode;
	}
	
	public String getStatusMessage() {
		return this.statusMessage;
	}

}
