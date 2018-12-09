package com.qa.service.business;

import java.util.Optional;

import com.qa.persistence.domain.User;

public interface UserService {

	Iterable<User> getAllUserAccounts();

	Optional<User> getUserAccount(Long userId);

	String addUserAccount(User user);

	String updateUserAccount(Long userId, String userName, String password);

	String deleteUserAccount(Long userId);

}
