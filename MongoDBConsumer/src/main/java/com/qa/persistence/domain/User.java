package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;


public class User {

	@Id
	@Column(name = "cvId")
	private Long cvId;

	@Column(name = "user_id")
	private Long userId;
	
	@Size(max = 12)
	@Column(name = "user_name", unique=true)
	private String userName;
	private String password;

	public User() {

	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
