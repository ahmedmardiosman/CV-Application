package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.AdminUser;

@Repository
public interface AdminUsersRepository extends MongoRepository<AdminUser, Long> {

}
