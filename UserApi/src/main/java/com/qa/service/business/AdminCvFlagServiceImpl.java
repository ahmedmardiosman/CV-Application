package com.qa.service.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;

@Service
public class AdminCvFlagServiceImpl implements AdminCvFlagService {
	
	@Autowired
	private UserRepository userRepo;

	public String updateFlag(Long userId, Boolean userCvFlagged) {

		User user = new User();
		user.setUserId(userId);
		user.setUserName(userRepo.findById(userId).get().getUserName());
		user.setPassword(userRepo.findById(userId).get().getPassword());
		user.setEmail(userRepo.findById(userId).get().getEmail());
		user.setIsCvFlagged(userCvFlagged);
		user.setCvs(userRepo.findById(userId).get().getCvs());
		
		userRepo.save(user);
		

		return "CV Flag on user " + userId + " has been updated";
	}

}
