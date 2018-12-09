package com.qa.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qa.service.business.CVService;

@CrossOrigin
@RequestMapping("${URL.base.CV}")
@RestController
public class CVEndpoints {

	@Autowired
	private CVService service;

	@PostMapping("${URL.method.uploadCV}")
	public String uploadCV(@PathVariable("userId") Long userId, @RequestParam("CV") MultipartFile CV)
			throws IOException {
		return service.uploadCV(userId, CV);
	}

	@GetMapping("${URL.method.downloadCV}")
	public ResponseEntity<Resource> downloadCV(@PathVariable("cvId") Long cvId) {
		return service.downloadCV(cvId);
	}
	
	@DeleteMapping("${URL.method.deleteCV}")
	public String deleteAdminAccount(@PathVariable("cvId") Long cvId) {
		return service.deleteCV(cvId);
	}
}
