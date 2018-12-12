package com.qa.service.buisness;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.qa.persistence.domain.CV;
import com.qa.persistence.repository.CVRepository;
import com.qa.persistence.repository.CommentsRepository;
import com.qa.util.EmailSender;

@Service
public class CVServiceImpl implements CVService {

	@Autowired
	private CVRepository cvRepo;

	@Autowired
	private CommentsRepository commentsRepo;

	@Autowired
	private EmailSender emailSender;

	public String uploadCV(Long userId, String email, MultipartFile CV) throws IOException {
//		commentsRepo.isCVFlagged(userId) == true

		String commentsJson = commentsRepo.findComments(userId).toString();

		CV userCV = new CV(userId, email, CV.getOriginalFilename(), CV.getBytes());

		if (commentsJson.contains("\"cvFlag\" : true")) {
			cvRepo.save(userCV);
			emailSender.sendEmail(userId);

			return "Your CV is Flagged";
		} else {

			cvRepo.save(userCV);

			return "CV has been successfully transfered to CV and Comments Database";
		}
	}

	public ResponseEntity<Resource> downloadCV(Long cvId) {

		Optional<CV> userCV = cvRepo.findById(cvId);

		userCV.get().getCvFile();

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + userCV.get().getFileName() + "\"")
				.body(new ByteArrayResource(userCV.get().getCvFile()));
	}

}
