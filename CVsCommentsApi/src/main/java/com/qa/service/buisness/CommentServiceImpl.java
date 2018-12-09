package com.qa.service.buisness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Comment;
import com.qa.persistence.repository.CommentsRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentsRepository commentRepo;


	
	public String transferComment(Comment comment) {

		commentRepo.save(comment);

		return "Comment has been transfered to CV and Comments Database";
	}

}
