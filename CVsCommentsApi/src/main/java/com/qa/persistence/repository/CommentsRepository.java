package com.qa.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.qa.persistence.domain.Comment;

public interface CommentsRepository extends CrudRepository<Comment, Long>{

	
	@Query ("SELECT p FROM Comment p WHERE user_id = (:user_id)")
	public List<Comment> findComments(@Param("user_id") Long userId);
	
}
