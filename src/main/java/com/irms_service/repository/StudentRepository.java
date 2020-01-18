package com.irms_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

	public List<StudentEntity> findByFirstName(String firstName);
	public List<StudentEntity> findByMiddleName(String middleName);
	public List<StudentEntity> findByLastName(String lastName);
	
	
	
}
