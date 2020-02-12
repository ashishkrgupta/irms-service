package com.irms_service.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irms_service.entity.Address;
import com.irms_service.entity.Document;
import com.irms_service.entity.EmergencyContact;
import com.irms_service.entity.Person;
import com.irms_service.entity.StudentEntity;
import com.irms_service.repository.AddressRepository;
import com.irms_service.repository.DocumentRepository;
import com.irms_service.repository.EmergencyContactRepository;
import com.irms_service.repository.PersonRepository;
import com.irms_service.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);


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
		LOGGER.info("Finding student with Id: " + id);
		return studentRepository.findById(id);
	}

	public StudentEntity getStudentByEnrollmentId(long id) {
		return studentRepository.findByEnrollmentId(id).get();
	}

	public StudentEntity newAddmission(StudentEntity student) {
		if(student.getId() == null) {
			LOGGER.info("Creating new student");
			student.setEnrollmentId(null);
			student.setLeavingDate(null);
			List<Person> persons = student.getRelatives();
			List<EmergencyContact> ecList = student.getEmergencyContacts();
			List<Document> documents = student.getDocuments();
			List<Address> addressList = student.getAddressList();
			studentRepository.save(student);
	
			student.setEnrollmentId("201001_" + student.getId());
			persons.stream().forEach(p -> p.setStudent(student));
			if (persons != null) {
				personRepository.saveAll(persons);
			}
			ecList.stream().forEach(e -> e.setStudent(student));
			if (ecList != null) {
				ecRepository.saveAll(ecList);
			}
			documents.stream().forEach(d -> d.setStudent(student));
			if (documents != null) {
				docRepository.saveAll(documents);
			}
			addressList.stream().forEach(address -> address.setStudent(student));
			if (addressList != null) {
				addressRepository.saveAll(addressList);
			}
			LOGGER.info("Created new student with Id: "+ student.getId());
			return studentRepository.findById(student.getId()).get();
		}else {
			LOGGER.info("Updatin student details with Id: "+ student.getId());
			List<Person> persons = student.getRelatives();
			List<EmergencyContact> ecList = student.getEmergencyContacts();
			List<Document> documents = student.getDocuments();
			List<Address> addressList = student.getAddressList();
			persons.stream().forEach(p -> p.setStudent(student));
			ecList.stream().forEach(e -> e.setStudent(student));
			documents.stream().forEach(d -> d.setStudent(student));
			addressList.stream().forEach(address -> address.setStudent(student));

			
			personRepository.saveAll(persons);
			ecRepository.saveAll(ecList);
			docRepository.saveAll(documents);
			addressRepository.saveAll(addressList);
			return studentRepository.save(student);
		}
	}

	public void updateStudentAddress(StudentEntity student) {
		studentRepository.save(student);
	}

	
	public List<StudentEntity> getAllStudentInfo() {
		//return studentRepository.findAll();
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
