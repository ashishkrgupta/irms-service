package com.irms_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irms_service.CustomResponseBody;
import com.irms_service.entity.Student;
import com.irms_service.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	StudentService service;

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
	public List<Student> getAllStudentInfo() {
		return service.getAllStudentInfo();
	}

	@GetMapping(value = "/firstName/{firstName}")
	public List<Student> getStudentByFirstName(@PathVariable("firstName") String firstName) {
		return service.getStudentByFirstName(firstName);
	}

	@GetMapping(value = "/middleName/{middleName}")
	public List<Student> getStudentByMiddleName(@PathVariable("middleName") String middleName) {
		return service.getStudentByMiddleName(middleName);
	}

	@GetMapping(value = "/lastName/{lastName}")
	public List<Student> getStudentByLastName(@PathVariable("lastName") String lastName) {
		return service.getStudentByLastName(lastName);
	}

	@GetMapping(value = "/standard/{standard}")
	public List<Student> getStudentsByAdmissionStandard(@PathVariable("standard") String standard) {
		return service.getStudentsByAdmissionStandard(standard);
	}
	
	
}
