package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.persistence.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
