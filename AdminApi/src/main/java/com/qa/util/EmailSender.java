package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.AdminUser;

@Service
public class EmailSender {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String sendEmail(AdminUser adminUser) throws MessagingException {

		SimpleMailMessage email = new SimpleMailMessage();

		email.setTo("ahmedmardiosman1994@gmail.com");
		email.setSubject("New Super User");
		email.setFrom("ahmedmardiosman@gmail.com");
		email.setText(adminUser.getAdminUserName() + " has become a new super Admin");
		javaMailSender.send(email);
		return "New Admin User has been sent an Email";
	}
}
