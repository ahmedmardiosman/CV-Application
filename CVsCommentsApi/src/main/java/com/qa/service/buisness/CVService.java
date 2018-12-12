package com.qa.service.buisness;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface CVService {

	String uploadCV(Long userId, String email, MultipartFile CV) throws IOException;

	ResponseEntity<Resource> downloadCV(Long cvId);

}
