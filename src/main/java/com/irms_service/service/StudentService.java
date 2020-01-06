package com.irms_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irms_service.dao.StudentDAO;
import com.irms_service.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDAO studentDAO;

	public Optional<Student> getStudentById(int id) {
		return studentDAO.findById(id);
	}
	
	public void newAddmission(Student student ) {
		student.setIsActive("Y");
		studentDAO.save(student);
	}
	
	public void updateStudentAddress(Student student) {
		studentDAO.save(student);
	}
	
	public List<Student> getAllStudentInfo() {
		return studentDAO.findAll();
	}
	
	public void deleteStudent(int id) {
		Student student = studentDAO.findById(id).orElseGet(null);
		student.setIsActive("N");
		studentDAO.save(student);
	}
}
