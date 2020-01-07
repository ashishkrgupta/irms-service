package com.irms_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irms_service.model.Student;
import com.irms_service.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping(value="/{id}")
	public Optional<Student> getStudentById(@PathVariable("id") int id){
		return service.getStudentById(id);
	}
	
	@PostMapping(value="")
	public void newAdmission(@RequestBody Student student) {
		service.newAddmission(student);
	}
	
//	@PatchMapping(value="updateAddress")
//	public void updateAddress(@RequestBody Student student) {
//		service.updateStudentAddress(student);
//	}
	
	@DeleteMapping("/{id}")
	public void removeStudent(@PathVariable("id") int id) {
		service.deleteStudent(id);
	}
	
	@GetMapping(value ="")
	public List<Student> getAllStudentInfo(){
		return service.getAllStudentInfo();
	}
}
