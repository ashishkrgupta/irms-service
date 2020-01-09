package com.irms_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irms_service.dao.StudentRepository;
import com.irms_service.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public Optional<Student> getStudentById(int id) {
		return studentRepository.findById(id);
	}
	
	public void newAddmission(Student student ) {
		student.setEnrollmentId("20200101");
		student.setLeavingDate(null);
		studentRepository.save(student);
	}
	
	public void updateStudentAddress(Student student) {
		studentRepository.save(student);
	}
	
	public List<Student> getAllStudentInfo() {
		return studentRepository.findAll();
	}
	
	public void deleteStudent(int id) {
		Student student = studentRepository.findById(id).orElseGet(null);
		if(Objects.isNull(student))
			return;
		student.setLeavingDate(LocalDateTime.now());
		studentRepository.save(student);
	}
}
