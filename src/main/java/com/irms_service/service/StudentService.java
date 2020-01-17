package com.irms_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irms_service.entity.AddressEntity;
import com.irms_service.entity.DocumentEntity;
import com.irms_service.entity.EmergencyContactEntity;
import com.irms_service.entity.PersonEntity;
import com.irms_service.entity.StudentEntity;
import com.irms_service.repository.AddressRepository;
import com.irms_service.repository.DocumentRepository;
import com.irms_service.repository.EmergencyContactRepository;
import com.irms_service.repository.PersonRepository;
import com.irms_service.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	EmergencyContactRepository ecRepository;

	@Autowired
	DocumentRepository docRepository;

	public Optional<StudentEntity> getStudentById(long id) {
		return studentRepository.findById(id);
	}

	public Optional<StudentEntity> newAddmission(StudentEntity student) {
		student.setEnrollmentId(null);
		student.setLeavingDate(null);
		studentRepository.save(student);
		List<PersonEntity> persons = student.getRelatives();
		List<EmergencyContactEntity> ecList = student.getEmergencyContacts();
		List<DocumentEntity> documents = student.getDocuments();
		List<AddressEntity> addressList = student.getAddressList();
		student.setEnrollmentId("201001_"+student.getId());
		persons.forEach(person ->{
			personRepository.save(person);
			person.setStudent(student);
		});
		
		ecList.forEach(ec ->{
			ecRepository.save(ec);
			ec.setStudent(student);
		});
		
		documents.forEach(document ->{
			docRepository.save(document);
			document.setStudent(student);
		});
		
		addressList.forEach(address ->{
			addressRepository.save(address);
			address.setStudent(student);
		});
		
		return studentRepository.findById(student.getId());
	}

	public void updateStudentAddress(StudentEntity student) {
		studentRepository.save(student);
	}

	public List<StudentEntity> getAllStudentInfo() {
		return studentRepository.findAll();
	}

	public void deleteStudent(long id) {
		StudentEntity student = studentRepository.findById(id).orElseGet(null);
		if (Objects.isNull(student))
			return;
		student.setLeavingDate(LocalDateTime.now());
		studentRepository.save(student);
	}

}
