package com.qa.service.buisness;

import java.util.Optional;

import com.qa.persistence.domain.AdminUser;

public interface AdminUserService {

	String addAdminAccount(AdminUser adminUser);

	Iterable<AdminUser> getAllAdminAccounts();

	Optional<AdminUser> getAdminAccount(Long adminId);

	String updateAdminAccount(Long adminId, String adminUserName, String password);

	String deleteAdminAccount(Long adminId);

}
