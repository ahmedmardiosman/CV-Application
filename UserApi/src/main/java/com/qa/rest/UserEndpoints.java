package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.User;
import com.qa.service.business.UserService;

@CrossOrigin
@RequestMapping("${URL.base.user}")
@RestController
public class UserEndpoints {
	
	@Autowired
	private UserService service;
	
	@GetMapping("${URL.method.getAllUserAccounts}")
	public Iterable<User> getAllUserAccounts() {
		return service.getAllUserAccounts();
	}

	@GetMapping("${URL.method.getUserAccount}")
	public Optional<User> getUserAccount(@PathVariable("userId") Long userId) {
		return service.getUserAccount(userId);
	}

	@PostMapping("${URL.method.addUserAccount}")
	public String addUserAccount(@RequestBody User user) {
		return service.addUserAccount(user);
	}

	@PutMapping("${URL.method.updateUserAccount}")
	public String updateUserAccount(@PathVariable("userId") Long userId,
			@PathVariable("userName") String userName, @PathVariable("password") String password) {
		return service.updateUserAccount(userId, userName, password);
	}

	@DeleteMapping("${URL.method.deleteUserAccount}")
	public String deleteUserAccount(@PathVariable("userId") Long userId) {
		return service.deleteUserAccount(userId);
	}
	
	

}
