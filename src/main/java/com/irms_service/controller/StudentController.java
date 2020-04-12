package com.irms_service.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.irms_service.entity.ApiResponse;
import com.irms_service.entity.Student;
import com.irms_service.exception.StudentException;
import com.irms_service.service.MiscConfigService;
import com.irms_service.service.StudentService;

@CrossOrigin()
@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	StudentService service;
	
	@Autowired
	MiscConfigService MiscConfigService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ApiResponse> getStudentById(@PathVariable("id") long id) {
		Optional<Student> studentOptional = service.getStudentById(id);
		if(studentOptional.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(studentOptional.get()), HttpStatus.OK);
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse(null, "Can not find Student with Id :" + id), HttpStatus.BAD_REQUEST);
	}

	@PostMapping(consumes = "multipart/form-data")
	public ResponseEntity<ApiResponse> newAddmissionOrEditStudent(@RequestParam String studentStr, 
			@RequestParam MultipartFile[] files) throws StudentException {
		Student student = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			student = mapper.readValue(studentStr, Student.class);
		} catch (JsonProcessingException e) {
			throw new StudentException(HttpStatus.BAD_REQUEST, "input data is invalid", e);
		}
		try {
			student = service.createEditStudent(student, files);
			return new ResponseEntity<ApiResponse>(new ApiResponse(student), HttpStatus.OK);
		} catch (IOException e) {
			throw new StudentException(HttpStatus.UNPROCESSABLE_ENTITY, "Could not create student", e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> removeStudent(@PathVariable("id") long id) {
		return new ResponseEntity<ApiResponse>(new ApiResponse(service.deleteStudent(id)), HttpStatus.OK);
	}

	@GetMapping(value = "")
	public ResponseEntity<ApiResponse> getAllStudentInfo() throws StudentException {
		try {
			return new ResponseEntity<ApiResponse>(new ApiResponse(service.getAllStudentInfo()), HttpStatus.OK);
		} catch (Exception e) {
			throw new StudentException(HttpStatus.EXPECTATION_FAILED, "Error while extracting students list.", e);
		}
	}

	@GetMapping(value = "/firstName/{firstName}")
	public ResponseEntity<ApiResponse> getStudentByFirstName(@PathVariable("firstName") String firstName) {
		return new ResponseEntity<ApiResponse>(new ApiResponse(service.getStudentByFirstName(firstName)), HttpStatus.OK);
	}

	@GetMapping(value = "/middleName/{middleName}")
	public ResponseEntity<ApiResponse> getStudentByMiddleName(@PathVariable("middleName") String middleName) {
		return new ResponseEntity<ApiResponse>(new ApiResponse(service.getStudentByMiddleName(middleName)), HttpStatus.OK);
	}

	@GetMapping(value = "/lastName/{lastName}")
	public ResponseEntity<ApiResponse> getStudentByLastName(@PathVariable("lastName") String lastName) {
		return new ResponseEntity<ApiResponse>(new ApiResponse(service.getStudentByLastName(lastName)), HttpStatus.OK);
	}

	@GetMapping(value = "/standard/{standard}")
	public ResponseEntity<ApiResponse> getStudentsByAdmissionStandard(@PathVariable("standard") String standard) {
		return new ResponseEntity<ApiResponse>(new ApiResponse(service.getStudentsByAdmissionStandard(standard)), HttpStatus.OK);
	}
	
	
}

	