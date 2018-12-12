package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String sendFlaggedCommentEmail(Long userId, String userEmail) throws MessagingException {

		SimpleMailMessage email = new SimpleMailMessage();

		email.setTo(userEmail);
		email.setSubject("Comment Flagged by an Admin User");
		email.setFrom("ahmedmardiosman@gmail.com");
		email.setText(" An Admin User has added a comment to your CV that needs attention");
		javaMailSender.send(email);
		return "Email has been send to user " + userId + " as a comment has been flagged by Admin";
	}
}
