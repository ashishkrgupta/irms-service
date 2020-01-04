package com.gurukul;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gurukul.model.Student;
import com.gurukul.service.StudentService;

@RestController
@RequestMapping("gurukulSchool")
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping(value="getStudentById/{id}")
	public Optional<Student> getStudentById(@PathVariable("id") int id){
		return service.getStudentById(id);
	}
	
	@PostMapping(value="newAdmission")
	public void newAdmission(@RequestBody Student student) {
		service.newAddmission(student);
	}
	
	@PatchMapping(value="updateAddress")
	public void updateAddress(@RequestBody Student student) {
		service.updateStudentAddress(student);
	}
	
	@DeleteMapping("removeStudent/{id}")
	public void removeStudent(@PathVariable("id") int id) {
		service.deleteStudent(id);
	}
	
	@GetMapping(value ="getAllStudentInfo")
	public List<Student> getAllStudentInfo(){
		return service.getAllStudentInfo();
	}
}
