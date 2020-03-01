package com.irms_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.MiscConfig;

@Repository
public interface MiscConfigRepository extends JpaRepository<MiscConfig, String> {

}
