package com.irms_service.exception;

import org.springframework.http.HttpStatus;

public class LibraryException extends IrmsException {

	private static final long serialVersionUID = 1L;

	public LibraryException(HttpStatus statusCode, String statusMessage, Throwable cause) {
		super(statusCode, statusMessage, cause);
	}

	public LibraryException(HttpStatus statusCode, String statusMessage) {
		super(statusCode, statusMessage);
	}

}
