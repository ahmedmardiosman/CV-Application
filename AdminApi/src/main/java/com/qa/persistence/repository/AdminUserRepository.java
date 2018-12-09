package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.persistence.domain.AdminUser;

public interface AdminUserRepository extends CrudRepository<AdminUser, Long> {

}
