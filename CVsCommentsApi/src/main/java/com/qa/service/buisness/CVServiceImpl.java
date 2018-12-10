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

@Service
public class CVServiceImpl implements CVService {

	@Autowired
	private CVRepository cvRepo;

	@Autowired
	private CommentsRepository commentsRepo;
	
	private Boolean isCVFlagged = false;

	public String uploadCV(Long userId, MultipartFile CV) throws IOException {
//		commentsRepo.isCVFlagged(userId) == true
		
		String commentsJson = commentsRepo.findComments(userId).toString();
		
		

		if (commentsJson.contains("\"cvFlag\" : true")) {
System.out.println("YourCV is flagged");
			return "Your CV is Flagged";
		} else {

			CV userCV = new CV(userId, CV.getOriginalFilename(), CV.getBytes());

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
