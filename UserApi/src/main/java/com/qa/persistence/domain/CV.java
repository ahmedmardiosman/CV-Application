package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CV {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cvId")
	private Long cvId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "file_name")
	private String fileName;

	@Lob
	@Column(name = "cv_file")
	private byte[] cvFile;

	public CV() {

	}
	
	public CV(Long userId, String fileName, byte[] cvFile) {
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

	public byte[] getCvFile() {
		return cvFile;
	}

	public void setCvFile(byte[] cvFile) {
		this.cvFile = cvFile;
	}

}
