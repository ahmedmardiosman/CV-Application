package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.persistence.domain.Comment;

public interface CommentsRepository extends CrudRepository<Comment, Long>{

}
