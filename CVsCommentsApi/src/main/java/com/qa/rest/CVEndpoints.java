package com.qa.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qa.service.buisness.CVService;

@CrossOrigin
@RequestMapping("${URL.base.CV}")
@RestController
public class CVEndpoints {

	@Autowired
	private CVService service;

	@PostMapping("${URL.method.uploadCV}")
	public String uploadCV(@PathVariable("userId") Long userId, @RequestParam("userEmail") String userEmail,
			@RequestParam("adminEmail") String adminEmail, @RequestParam("isCvFlagged") Boolean isUserFlagged,
			@RequestParam("CV") MultipartFile CV) throws IOException {
		return service.uploadCV(userId, userEmail, adminEmail, isUserFlagged, CV);
	}

	@GetMapping("${URL.method.downloadCV}")
	public ResponseEntity<Resource> downloadCV(@PathVariable("cvId") Long cvId) {
		return service.downloadCV(cvId);
	}

}
