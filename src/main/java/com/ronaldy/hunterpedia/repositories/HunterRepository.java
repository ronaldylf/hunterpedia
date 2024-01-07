package com.ronaldy.hunterpedia.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ronaldy.hunterpedia.entities.Hunter;

public interface HunterRepository extends JpaRepository<Hunter, UUID>{
	@Query(value = "SELECT * FROM tb_hunters WHERE "
			+ "name LIKE %:name% AND "
			+ "gender LIKE %:gender% AND "
			+ "nen_type LIKE %:nen_type%",
			nativeQuery = true)
	public List<Hunter> getHuntersBySearchParams(@Param("name") String name, @Param("gender") String gender, @Param("nen_type") String nen_type);
}
