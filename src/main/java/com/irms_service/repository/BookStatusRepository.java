package com.irms_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.BookStatus;

@Repository
public interface BookStatusRepository extends JpaRepository<BookStatus, Long>{

	public List<BookStatus> findByStudentId(Long id);
}
