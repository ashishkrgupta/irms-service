package com.irms_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByFirstName(String firstName);
	public List<Student> findByMiddleName(String middleName);
	public List<Student> findByLastName(String lastName);
	public List<Student> findByAddmissionStandard(String addmissionStandard);
	
	@Query(value = "select s from StudentEntity s where leavingDate is null")
	public List<Student> findAllActiveStudent();
	public Optional<Student> findByEnrollmentId(long id);
		
	
}
