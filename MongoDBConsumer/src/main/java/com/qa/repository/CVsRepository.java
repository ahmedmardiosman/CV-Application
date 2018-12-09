package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.CVBinary;

@Repository
public interface CVsRepository extends MongoRepository<CVBinary, Long>{

}
