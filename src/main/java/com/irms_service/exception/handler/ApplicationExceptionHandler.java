package com.irms_service.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.irms_service.entity.ApiResponse;
import com.irms_service.exception.LibraryException;
import com.irms_service.exception.StudentException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(value = StudentException.class)
	public ResponseEntity<ApiResponse> handleStudentException(StudentException exception) {
		exception.printStackTrace();
		return new ResponseEntity<ApiResponse>(new ApiResponse(null, exception.getStatusMessage() + " Reason: " + exception.getMessage()), exception.getStatusCode());
	}
	
	@ExceptionHandler(value = LibraryException.class)
	public ResponseEntity<ApiResponse> handleLibraryException(LibraryException exception) {
		exception.printStackTrace();
		return new ResponseEntity<ApiResponse>(new ApiResponse(null, exception.getStatusMessage() + " Reason: " + exception.getMessage()), exception.getStatusCode());
	}
}
