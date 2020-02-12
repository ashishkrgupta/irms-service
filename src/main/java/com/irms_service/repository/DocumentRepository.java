package com.irms_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

	
}
