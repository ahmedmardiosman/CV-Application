package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class AdminUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "admin_id")
	private Long adminId;

	@Size(max = 12)
	@Column(name = "user_name", unique = true)
	private String adminUserName;
	private String password;
	private String email;
	
	@Column(name = "is_super_admin")
	private Boolean isSuperAdmin = false;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
	private List<Comment> comments;

	public AdminUser() {

	}

	public Long getAdminId() {
		return adminId;
	}


	public String getAdminUserName() {
		return adminUserName;
	}

	public List<Comment> getComments() {
		return comments;
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

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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

}
