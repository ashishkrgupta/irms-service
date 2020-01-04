package com.gurukul.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gurukul.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

	
}
