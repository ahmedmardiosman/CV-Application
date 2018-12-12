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
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class CV {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cv_id")
	private Long cvId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "admin_email")
	private String adminEmail;

	@Column(name = "file_name")
	private String fileName;

	@Lob
	@Column(name = "cv_file")
	private byte[] cvFile;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
	private List<Comment> comments;

	public CV() {

	}

	public CV(Long userId, String userEmail, String adminEmail, String fileName, byte[] cvFile) {
		this.userId = userId;
		this.userEmail = userEmail;
		this.adminEmail = adminEmail;
		this.fileName = fileName;
		this.cvFile = cvFile;

	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Long getCvId() {
		return cvId;
	}

	public void setCvId(Long cvId) {
		this.cvId = cvId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getCvFile() {
		return cvFile;
	}

	public void setCvFile(byte[] cvFile) {
		this.cvFile = cvFile;
	}

}
