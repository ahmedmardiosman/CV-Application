package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.LoginDetails;
import com.qa.service.business.LoginDetailsService;
import com.qa.service.business.LoginDetailsServiceImpl.Response;

@CrossOrigin
@RequestMapping("${URL.base.userLogin}")
@RestController
public class UserLoginEndpoint {
	
	@Autowired
	private LoginDetailsService service;

	@PostMapping("${URL.method.checkLoginDetails}")
	public Response checkLoginDetails(@RequestBody LoginDetails loginDetails) {
		return service.checkLoginDetials(loginDetails);
	}
	
	
}
