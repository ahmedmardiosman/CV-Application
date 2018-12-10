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

	public String sendEmail(Long userId) throws MessagingException {

		SimpleMailMessage email = new SimpleMailMessage();

		email.setTo("ahmedmardiosman1994@gmail.com");
		email.setSubject("Flagged User ");
		email.setFrom("ahmedmardiosman@gmail.com");
		email.setText(userId + " CV is Flagged and has uploaded a new CV");
		javaMailSender.send(email);
		return "Flagged CV email with user info has been sent to Admin";
	}
}
