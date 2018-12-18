package com.qa.service.business;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.LoginDetails;
import com.qa.persistence.domain.User;
import com.qa.persistence.repository.UserRepository;

@Service
public class LoginDetailsServiceImpl implements LoginDetailsService {

	@Autowired
	private UserRepository userRepo;

	public Response checkLoginDetials(LoginDetails loginDetails) {

		List<User> userDetailsDb = userRepo.findLogginDetails(loginDetails.getLoginUserName());

		try {
			BCrypt.checkpw(loginDetails.getLoginPassword(), userDetailsDb.get(0).getPassword());
		} catch (IndexOutOfBoundsException e) {
			Response response = new Response();
			response.setMessage("Incorrect loggin Details Entered");
			return response;
		}
		
		Response responseC = new Response();
		responseC.setMessage("Correct loggin Details Entered");
		responseC.setUserId(userDetailsDb.get(0).getUserId());

		return responseC;
	}
	
	public class Response {
		
		private String message;
		
		private Long userId;
		
		public Response() {
			
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		
		
		
		
	}

}
