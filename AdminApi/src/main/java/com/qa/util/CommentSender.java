package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.qa.persistence.domain.Comment;

@Component
public class CommentSender {

	@Autowired
	private RestTemplate rest;
	
	
	public String send(Comment comment) {
	
		rest.postForEntity("http://localhost:8087/CommentTransfer/comment", comment, String.class);
		return "Comment has been successfully sent";
	}

}
