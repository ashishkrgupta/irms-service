package com.irms_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irms_service.entity.AddressEntity;
import com.irms_service.entity.StudentEntity;
import com.irms_service.model.GenericRequestBody;
import com.irms_service.repository.AddressRepository;
import com.irms_service.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;
	
	public Optional<StudentEntity> getStudentById(int id) {
		return studentRepository.findById(id);
	}
	
	public void newAddmission(StudentEntity student ) {
		student.setEnrollmentId("20200101");
		student.setLeavingDate(null);
		studentRepository.save(student);
	}
	
	public void updateStudentAddress(StudentEntity student) {
		studentRepository.save(student);
	}
	
	public List<StudentEntity> getAllStudentInfo() {
		return studentRepository.findAll();
	}
	
	public void deleteStudent(int id) {
		StudentEntity student = studentRepository.findById(id).orElseGet(null);
		if(Objects.isNull(student))
			return;
		student.setLeavingDate(LocalDateTime.now());
		studentRepository.save(student);
	}

	public void newAddmissionRequst(GenericRequestBody request) {
		
		StudentEntity student = new StudentEntity(request.getStudent());
		studentRepository.save(student);
		AddressEntity address = new AddressEntity(request.getAddress());
		addressRepository.save(address);
		student.setAddress(address);
		address.setStudent(student);
		
	}
}
