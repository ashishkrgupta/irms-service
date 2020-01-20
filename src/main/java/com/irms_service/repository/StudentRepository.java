package com.irms_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

	public List<StudentEntity> findByFirstName(String firstName);
	public List<StudentEntity> findByMiddleName(String middleName);
	public List<StudentEntity> findByLastName(String lastName);
	public List<StudentEntity> findByAddmissionStandard(String addmissionStandard);
	
	@Query(value = "select * from student where leaving_date is null", nativeQuery = true)
	public List<StudentEntity> findAllActiveStudent();
		
	
}
