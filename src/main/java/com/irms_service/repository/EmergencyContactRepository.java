package com.irms_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.EmergencyContactEntity;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContactEntity, Long>{

	
}
