package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.bson.types.Binary;


public class CVBinary {

	@Id
	@Column(name = "cvId")
	private Long cvId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "file_name")
	private String fileName;

	
	@Column(name = "cv_file")
	private Binary cvFile;

	public CVBinary() {

	}
	
	public CVBinary(Long userId, String fileName, Binary cvFile) {
		this.userId = userId;
		this.fileName = fileName;
		this.cvFile = cvFile;

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Binary getCvFile() {
		return cvFile;
	}

	public void setCvFile(Binary cvFile) {
		this.cvFile = cvFile;
	}

}
