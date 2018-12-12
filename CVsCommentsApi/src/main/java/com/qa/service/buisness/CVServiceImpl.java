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

import com.qa.persistence.domain.CV;
import com.qa.persistence.repository.CVRepository;
import com.qa.persistence.repository.CommentsRepository;
import com.qa.util.EmailSender;

@Service
public class CVServiceImpl implements CVService {

	@Autowired
	private CVRepository cvRepo;

	@Autowired
	private EmailSender emailSender;

	public String uploadCV(Long userId, String userEmail, String adminEmail, Boolean isUserFlagged, MultipartFile CV)
			throws IOException {

		CV userCV = new CV(userId, userEmail, adminEmail, CV.getOriginalFilename(), CV.getBytes());

		if (isUserFlagged == true) {
			cvRepo.save(userCV);
			emailSender.sendFlaggedUserEmail(userId, adminEmail);

			return "Your CV is Flagged";
		} else {

			cvRepo.save(userCV);

			return "Your CV was not Flagged";
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

//public String uploadCV(Long userId, String email, Boolean isUserFlagged, MultipartFile CV) throws IOException {
//
//
//	String commentsJson = commentsRepo.findComments(userId).toString();
//
//	CV userCV = new CV(userId, email, CV.getOriginalFilename(), CV.getBytes());
//
//	if (commentsJson.contains("\"cvFlag\" : true")) {
//		cvRepo.save(userCV);
////		emailSender.sendEmail(userId, email);
//
//		return "Your CV is Flagged";
//	} else {
//
//		cvRepo.save(userCV);
//
//		return email;
//	}
//}
