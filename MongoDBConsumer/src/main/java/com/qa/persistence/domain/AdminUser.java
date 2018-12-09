package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class AdminUser {

	@Id
	private Long adminId;

	@Column(name = "user_name")
	private String adminUserName;

	private String password;

	private String email;
	@Column(name = "is_super_admin")
	private Boolean isSuperAdmin = false;

	public AdminUser() {

	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getIsSuperAdmin() {
		return isSuperAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIsSuperAdmin(Boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PojoAccount [adminId=" + adminId + ", userName=" + adminUserName + ", password=" + password + "]";
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

}
