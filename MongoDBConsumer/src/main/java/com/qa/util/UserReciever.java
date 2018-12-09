package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.User;
import com.qa.service.UserService;



@Component
public class UserReciever {

	@Autowired
	private UserService service;

	@JmsListener(destination = "UserDetailsForMongoDB", containerFactory = "myFactory")
	public void receiveMessage(User user) {
		service.add(user);
	}
}
