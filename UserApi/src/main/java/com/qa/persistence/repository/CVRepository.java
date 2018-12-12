package com.qa.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.qa.persistence.domain.CV;

public interface CVRepository extends CrudRepository<CV, Long> {
	
	@Query ("SELECT p FROM CV p WHERE user_id = (:user_id)")
	public List<CV> findAdminEmail(@Param("user_id") Long userId);

}
