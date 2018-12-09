package com.qa.service.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;
import com.qa.util.UserProducerJMS;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProducerJMS userProducer;

	public String addUserAccount(User user) {
		userRepository.save(user);
		userProducer.produce(user);
		return "User Account Added Successfully";
	}

	public Iterable<User> getAllUserAccounts() {
		return userRepository.findAll();
	}

	public Optional<User> getUserAccount(Long userId) {
		return userRepository.findById(userId);
	}

	public String updateUserAccount(Long userId, String userName, String password) {

		User User = new User();
		User.setUserId(userId);
		User.setUserName(userName);
		User.setPassword(password);
		User.setCvs(userRepository.findById(userId).get().getCvs());
		userRepository.save(User);

		return "User Account has been successfully updated";
	}

	public String deleteUserAccount(Long userId) {
		userRepository.deleteById(userId);
		return "User User Successfully Deleted";

	}

}
