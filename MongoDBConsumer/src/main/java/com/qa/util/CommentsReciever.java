package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.Comment;
import com.qa.service.CommentService;

@Component
public class CommentsReciever {
	
	@Autowired
	private CommentService service;

	@JmsListener(destination = "CommentDetailsForMongoDB", containerFactory = "myFactory")
	public void receiveMessage(Comment comment) {
		service.add(comment);
	}
}
