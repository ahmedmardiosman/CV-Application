package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;

	@Column(name = "admin_id")
	private Long adminId;

	private Long userId;

	@Column(name = "cv_id")
	private Long cvId;
	
	@Column(name = "cv_flag")
	private Boolean cvFlag;

	private String comment;

	public Comment() {

	}

	public Long getAdminId() {
		return adminId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getCommentId() {
		return commentId;
	}

	public Boolean getCvFlag() {
		return cvFlag;
	}

	public Long getCvId() {
		return cvId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}


	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public void setCvFlag(Boolean cvFlag) {
		this.cvFlag = cvFlag;
	}

	public void setCvId(Long cvId) {
		this.cvId = cvId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}
