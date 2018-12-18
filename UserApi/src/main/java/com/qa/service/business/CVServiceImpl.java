package com.qa.service.business;

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
import com.qa.persistence.repository.UserRepository;
import com.qa.util.CVProducerJMS;
import com.qa.util.CVSender;

@Service
public class CVServiceImpl implements CVService {

	@Autowired
	private CVRepository cvRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CVProducerJMS cvProducer;

	@Autowired
	private CVSender cvInfo;

	public String uploadCV(Long userId, MultipartFile CV) throws IOException {

		CV userCV = new CV(userId, CV.getOriginalFilename(), CV.getBytes());
		cvRepo.save(userCV);
		
		String userEmail = userRepo.findById(userId).get().getEmail();
		System.out.println(userEmail);
		Boolean isCvFlagged = userRepo.findById(userId).get().getIsCvFlagged();
		String adminEmail = cvRepo.findAdminEmail(userId).get(0).getAdminEmail();

System.out.println(isCvFlagged);
System.out.println(adminEmail);
		cvInfo.send(userId, userEmail, adminEmail, isCvFlagged, CV);

		cvProducer.produce(userCV);

		return "CV has been successfully Uploaded";
	}

	public ResponseEntity<Resource> downloadCV(Long cvId) {

		Optional<CV> userCV = cvRepo.findById(cvId);

		userCV.get().getCvFile();

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + userCV.get().getFileName() + "\"")
				.body(new ByteArrayResource(userCV.get().getCvFile()));
	}

	public String deleteCV(Long cvId) {
		cvRepo.deleteById(cvId);
		return "CV " + cvId + " has been successfully deleted";
	}

}
