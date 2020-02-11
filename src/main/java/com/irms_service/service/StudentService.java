package com.irms_service.service;

import java.util.Date;
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

	public StudentEntity getStudentById(long id) {
		StudentEntity student = studentRepository.findById(id).get();
		student.setAddressList(addressRepository.getAddressByStudentId(student.getId()));
		return student;
	}

	public Optional<StudentEntity> getStudentByEnrollmentId(long id) {
		return studentRepository.findByEnrollmentId(id);
	}

	public Optional<StudentEntity> newAddmission(StudentEntity student) {
		student.setEnrollmentId(null);
		student.setLeavingDate(null);
		studentRepository.save(student);
		List<PersonEntity> persons = student.getRelatives();
		List<EmergencyContactEntity> ecList = student.getEmergencyContacts();
		List<DocumentEntity> documents = student.getDocuments();
		List<AddressEntity> addressList = student.getAddressList();
		addressList.stream().forEach(address -> address.setStudent(student));
		student.setEnrollmentId("201001_" + student.getId());
		if (persons != null) {
			personRepository.saveAll(persons);
		}
		if (ecList != null) {
			ecRepository.saveAll(ecList);
		}
		if (documents != null) {
			docRepository.saveAll(documents);
		}
		if (addressList != null) {
			addressRepository.saveAll(addressList);
		}
		return studentRepository.findById(student.getId());
	}

	public void updateStudentAddress(StudentEntity student) {
		studentRepository.save(student);
	}

	public List<StudentEntity> getAllStudentInfo() {
		// return studentRepository.findAll();
		return studentRepository.findAllActiveStudent();
	}

	public void deleteStudent(long id) {
		StudentEntity student = studentRepository.findById(id).orElseGet(null);
		if (Objects.isNull(student))
			return;
		student.setLeavingDate(new Date());
		studentRepository.save(student);
	}

	public List<StudentEntity> getStudentByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}

	public List<StudentEntity> getStudentByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	public List<StudentEntity> getStudentByMiddleName(String middleName) {
		return studentRepository.findByMiddleName(middleName);
	}

	public List<StudentEntity> getStudentsByAdmissionStandard(String admissionStandard) {
		return studentRepository.findByAddmissionStandard(admissionStandard);
	}
}
