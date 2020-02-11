package com.irms_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.irms_service.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long>{
	
	@Query(value = "select * from Address where student.id = ?1", nativeQuery = true)
	public List<AddressEntity> getAddressByStudentId(long id);

	
}
