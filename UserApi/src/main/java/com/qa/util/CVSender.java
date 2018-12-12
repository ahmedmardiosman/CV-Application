package com.qa.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CVSender {

	@Autowired
	private RestTemplate rest;

	public String send(Long userId, String email, MultipartFile CV) throws IOException {

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

		ByteArrayResource contentsAsResource = new ByteArrayResource(CV.getBytes()) {
			@Override
			public String getFilename() {
				return CV.getOriginalFilename(); // Filename has to be returned in order to be able to post.
			}
		};

		map.add("CV", contentsAsResource);

		rest.postForObject("http://localhost:8087/CVTransfer/uploadCV/" + userId + "/" + email, map, String.class);
		return "CV has been successfully sent";

	}

}
