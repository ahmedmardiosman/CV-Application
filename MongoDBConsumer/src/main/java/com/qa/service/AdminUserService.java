package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.AdminUser;
import com.qa.repository.AdminUsersRepository;

@Service
public class AdminUserService {

	@Autowired
	private AdminUsersRepository adminUserRepo;

	public AdminUser add(AdminUser adminUser) {
		return adminUserRepo.save(adminUser);
	}

}
