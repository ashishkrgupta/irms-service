package com.irms_service.exception;

import org.springframework.http.HttpStatus;

public class StudentException extends IrmsException {

	private static final long serialVersionUID = 1L;

	public StudentException(HttpStatus statusCode, String statusMessage, Throwable cause) {
		super(statusCode, statusMessage, cause);
	}

	public StudentException(HttpStatus statusCode, String statusMessage) {
		super(statusCode, statusMessage);
	}

}
