package com.qa.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.qa.persistence.domain.Comment;

public interface CommentsRepository extends CrudRepository<Comment, Long>{

	
	@Query ("SELECT p FROM Comment p WHERE user_id = (:user_id)")
	public List<Comment> findComments(@Param("user_id") Long userId);
	
//	
//	@Query ("SELECT user_id, cv_flag FROM cvsandcomments.comment where user_id = :userId AND cv_flag = '1' lIMIT 1")
//	public Boolean isCVFlagged(@Param("userId") Long userId);
}
