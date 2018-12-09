package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.User;

@Component
public class UserProducerJMS {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(User user) {
		jmsTemplate.convertAndSend("UserDetailsForMongoDB", user);
		return "Admin Details have been sent to the Que";
	}
	
	
}
