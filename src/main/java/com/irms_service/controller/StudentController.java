package com.irms_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irms_service.CustomResponseBody;
import com.irms_service.entity.Student;
import com.irms_service.service.MiscConfigService;
import com.irms_service.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	StudentService service;
	
	@Autowired
	MiscConfigService MiscConfigService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CustomResponseBody> getStudentById(@PathVariable("id") long id) {
		Optional<Student> studentOptional = service.getStudentById(id);
		if(studentOptional.isPresent()) {
			return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(studentOptional.get()), HttpStatus.OK);
		}
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(null, "Can not find Student with Id :" + id), HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public ResponseEntity<CustomResponseBody> newAddmissionOrEditStudent(@RequestBody Student student) {
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(service.newAddmissionOrEditStudent(student)), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomResponseBody> removeStudent(@PathVariable("id") long id) {
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(service.deleteStudent(id)), HttpStatus.OK);
	}

	@GetMapping(value = "")
	public ResponseEntity<CustomResponseBody> getAllStudentInfo() {
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(service.getAllStudentInfo()), HttpStatus.OK);
	}

	@GetMapping(value = "/firstName/{firstName}")
	public ResponseEntity<CustomResponseBody> getStudentByFirstName(@PathVariable("firstName") String firstName) {
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(service.getStudentByFirstName(firstName)), HttpStatus.OK);
	}

	@GetMapping(value = "/middleName/{middleName}")
	public ResponseEntity<CustomResponseBody> getStudentByMiddleName(@PathVariable("middleName") String middleName) {
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(service.getStudentByMiddleName(middleName)), HttpStatus.OK);
	}

	@GetMapping(value = "/lastName/{lastName}")
	public ResponseEntity<CustomResponseBody> getStudentByLastName(@PathVariable("lastName") String lastName) {
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(service.getStudentByLastName(lastName)), HttpStatus.OK);
	}

	@GetMapping(value = "/standard/{standard}")
	public ResponseEntity<CustomResponseBody> getStudentsByAdmissionStandard(@PathVariable("standard") String standard) {
		return new ResponseEntity<CustomResponseBody>(new CustomResponseBody(service.getStudentsByAdmissionStandard(standard)), HttpStatus.OK);
	}
	
	
}
