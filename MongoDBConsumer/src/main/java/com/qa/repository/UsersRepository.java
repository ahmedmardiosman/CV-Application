package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.User;

@Repository
public interface UsersRepository extends MongoRepository<User, Long> {

}
