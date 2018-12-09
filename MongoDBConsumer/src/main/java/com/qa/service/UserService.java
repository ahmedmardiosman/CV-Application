package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.User;
import com.qa.repository.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository userRepo;

	public User add(User user) {
		return userRepo.save(user);
	}
}
