package com.qa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.Comment;

@Repository
public interface CommentsRepository extends MongoRepository<Comment, Long> {

}
