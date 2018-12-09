package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.AdminUser;
import com.qa.service.AdminUserService;

@Component
public class AdminUserReciever {

	@Autowired
	private AdminUserService service;

	@JmsListener(destination = "AdminDetailsForMongoDB", containerFactory = "myFactory")
	public void receiveMessage(AdminUser adminUser) {
		service.add(adminUser);
	}

}
