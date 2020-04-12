package com.irms_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, Long> {

}
