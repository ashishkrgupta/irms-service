package com.irms_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irms_service.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

	
}
