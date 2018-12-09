package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.CV;

@Component
public class CVProducerJMS {

	
	@Autowired
	private JmsTemplate jmsTemplate;

	public String produce(CV userCV) {
				
		jmsTemplate.convertAndSend("CVDetailsForMongoDB", userCV);
		return "Admin Details have been sent to the Que";
	}
}
