package com.irms_service.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.irms_service.entity.Address;
import com.irms_service.entity.Document;
import com.irms_service.entity.EmergencyContact;
import com.irms_service.entity.Person;
import com.irms_service.entity.Student;
import com.irms_service.repository.AddressRepository;
import com.irms_service.repository.DocumentRepository;
import com.irms_service.repository.EmergencyContactRepository;
import com.irms_service.repository.PersonRepository;
import com.irms_service.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

	@Value("${irmsService.uploadToDB}")
	private boolean uploadToDb;
	
	@Value("${irmsService.uploadLocation}")
	private String uploadLoc;
	
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

	public Optional<Student> getStudentById(long id) {
		LOGGER.info("Finding student with Id: " + id);
		return studentRepository.findById(id);
	}

	public Student getStudentByEnrollmentId(long id) {
		return studentRepository.findByEnrollmentId(id).get();
	}

	public Student createEditStudent(Student student, MultipartFile[] files) throws IOException {
		
		List<Person> persons = student.getRelatives();
		List<EmergencyContact> ecList = student.getEmergencyContacts();
		List<Document> documents = student.getDocuments();
		List<Address> addressList = student.getAddressList();
		studentRepository.save(student);
		student.setEnrollmentId("201001_" + student.getId());
		if (persons != null) {
			persons.stream().forEach(p -> p.setStudent(student));
			personRepository.saveAll(persons);
		}
		if (ecList != null) {
			ecList.stream().forEach(e -> e.setStudent(student));
			ecRepository.saveAll(ecList);
		}
		if (documents != null) {
			for ( Document d : documents) {
				d.setStudent(student);
				if (uploadToDb) {
					d.setFileData(getFileData(files, d.getFileName()));
				} else {
					d.setFilePath(getFilePath(files, d.getFileName()));
				}
			}
			docRepository.saveAll(documents);
		}
		if (addressList != null) {
			addressList.stream().forEach(address -> address.setStudent(student));
			addressRepository.saveAll(addressList);
		}
		LOGGER.info("New addmission succeed with student Id: " + student.getId());
		return student;
		
		
		
//		if (student.getId() == null) {
//			LOGGER.info("New addmission");
//			student.setEnrollmentId(null);
//			student.setLeavingDate(null);
//			List<Person> persons = student.getRelatives();
//			List<EmergencyContact> ecList = student.getEmergencyContacts();
//			List<Document> documents = student.getDocuments();
//			List<Address> addressList = student.getAddressList();
//			studentRepository.save(student);
//
//			student.setEnrollmentId("201001_" + student.getId());
//			persons.stream().forEach(p -> p.setStudent(student));
//			if (persons != null) {
//				personRepository.saveAll(persons);
//			}
//			ecList.stream().forEach(e -> e.setStudent(student));
//			if (ecList != null) {
//				ecRepository.saveAll(ecList);
//			}
//			documents.stream().forEach(d -> d.setStudent(student));
//			if (documents != null) {
//				docRepository.saveAll(documents);
//			}
//			addressList.stream().forEach(address -> address.setStudent(student));
//			if (addressList != null) {
//				addressRepository.saveAll(addressList);
//			}
//			LOGGER.info("New addmission succeed with student Id: " + student.getId());
//			return studentRepository.findById(student.getId()).get();
//		} else {
//			LOGGER.info("Updating student details with Id: " + student.getId());
//			List<Person> persons = student.getRelatives();
//			List<EmergencyContact> ecList = student.getEmergencyContacts();
//			List<Document> documents = student.getDocuments();
//			List<Address> addressList = student.getAddressList();
//			persons.stream().forEach(p -> p.setStudent(student));
//			if (persons != null) {
//				personRepository.saveAll(persons);
//			}
//			ecList.stream().forEach(e -> e.setStudent(student));
//			if (ecList != null) {
//				ecRepository.saveAll(ecList);
//			}
//			documents.stream().forEach(d -> d.setStudent(student));
//			if (documents != null) {
//				docRepository.saveAll(documents);
//			}
//			addressList.stream().forEach(address -> address.setStudent(student));
//			if (addressList != null) {
//				addressRepository.saveAll(addressList);
//			}
//			LOGGER.info("Student details updated with student id: " + student.getId());
//			return studentRepository.save(student);
//		}
	}
	
	private String getFilePath(MultipartFile[] files, String fileName) throws IOException {
		for (MultipartFile file : files) {
			if (file.getOriginalFilename().equals(fileName)) {
				Path path = Paths.get(uploadLoc + file.getOriginalFilename());
		        Files.write(path, file.getBytes());
				return path.toString();
			}
		}
		return null;
	}

	private byte[] getFileData(MultipartFile[] files, String fileName) throws IOException {
		for (MultipartFile file : files) {
			if (file.getOriginalFilename().equals(fileName)) {
				return file.getBytes();
			}
		}
		return null;
	}

	public void updateStudentAddress(Student student) {
		studentRepository.save(student);
	}

	public List<Student> getAllStudentInfo() {
		LOGGER.info("Fetching details of all active students");
		return studentRepository.findAllActiveStudent();
	}

	public Student deleteStudent(long id) {
		LOGGER.info("Marking school leaving date for student id: " + id);
		Student student = studentRepository.findById(id).orElseGet(null);
		if (Objects.isNull(student))
			return null;
		student.setLeavingDate(new Date());
		LOGGER.info("School leaving date marked for student id: " + id);
		return studentRepository.save(student);
	}

	public List<Student> getStudentByLastName(String lastName) {
		LOGGER.info("Finding students with last name: " + lastName);
		return studentRepository.findByLastName(lastName);
	}

	public List<Student> getStudentByFirstName(String firstName) {
		LOGGER.info("Finding students with first name: " + firstName);
		return studentRepository.findByFirstName(firstName);
	}

	public List<Student> getStudentByMiddleName(String middleName) {
		LOGGER.info("Finding students with middle name: " + middleName);
		return studentRepository.findByMiddleName(middleName);
	}

	public List<Student> getStudentsByAdmissionStandard(String admissionStandard) {
		LOGGER.info("Finding students who are studying in standard: " + admissionStandard);
		return studentRepository.findByAddmissionStandard(admissionStandard);
	}
}
