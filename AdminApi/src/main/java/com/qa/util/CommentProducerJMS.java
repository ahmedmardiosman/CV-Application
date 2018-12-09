package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.Comment;

@Component
public class CommentProducerJMS {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(Comment comment) {
		jmsTemplate.convertAndSend("CommentDetailsForMongoDB", comment);
		return "Comment Details have been sent to the Que";
	}
}
