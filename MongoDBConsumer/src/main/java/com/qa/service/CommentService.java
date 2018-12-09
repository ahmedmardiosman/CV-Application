package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Comment;
import com.qa.repository.CommentsRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentsRepository commentRepo;

	public Comment add(Comment comment) {
		return commentRepo.save(comment);
	}
}
