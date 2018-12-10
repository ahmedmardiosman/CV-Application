package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.persistence.domain.CV;


public interface CVRepository extends CrudRepository<CV, Long> {

}
