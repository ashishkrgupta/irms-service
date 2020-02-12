package com.irms_service.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.irms_service.CustomResponseBody;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<CustomResponseBody> exception(Exception exception) {
		exception.printStackTrace();
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(null, "Something went wrong"), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
