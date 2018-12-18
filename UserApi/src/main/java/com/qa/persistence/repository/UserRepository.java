package com.qa.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.qa.persistence.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query ("SELECT p FROM User p WHERE user_name = (:user_name)")
	public List<User> findLogginDetails(@Param("user_name") String logginUserName);
}
