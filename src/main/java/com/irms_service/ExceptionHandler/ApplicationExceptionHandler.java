package com.irms_service.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		exception.printStackTrace();
		return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
	}
}
