package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.AdminUser;

@Component
public class AdminUserProducerJMS {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(AdminUser adminUser) {
		jmsTemplate.convertAndSend("AdminDetailsForMongoDB", adminUser);
		return "Admin Details have been sent to the Que";
	}

}
