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

import com.qa.persistence.domain.AdminUser;
import com.qa.service.buisness.AdminUserService;

@CrossOrigin
@RequestMapping("${URL.base.adminAccount}")
@RestController
public class AdminUserEndpoints {

	@Autowired
	private AdminUserService service;

	@GetMapping("${URL.method.getAllAdminAccounts}")
	public Iterable<AdminUser> getAllAdminAccounts() {
		return service.getAllAdminAccounts();
	}

	@GetMapping("${URL.method.getAdminAccount}")
	public Optional<AdminUser> getAdminAccount(@PathVariable("adminId") Long adminId) {
		return service.getAdminAccount(adminId);
	}

	@PostMapping("${URL.method.addAdminAccount}")
	public String addAdminAccount(@RequestBody AdminUser adminUser) {
		return service.addAdminAccount(adminUser);
	}
	
//	{
//		"adminUserName" = "ahmedOsma",
//	    "password": "ahmed",
//	    "email": "ahmedmardiosman@gmail.com",
//		"isSuperAdmin" : "true"
//	}

	@PutMapping("${URL.method.updateAdminAccount}")
	public String updateAdminAccount(@PathVariable("adminId") Long adminId,
			@PathVariable("adminUserName") String adminUserName, @PathVariable("password") String password) {
		return service.updateAdminAccount(adminId, adminUserName, password);
	}

	@DeleteMapping("${URL.method.deleteAdminAccount}")
	public String deleteAdminAccount(@PathVariable("adminId") Long adminId) {
		return service.deleteAdminAccount(adminId);
	}

}
