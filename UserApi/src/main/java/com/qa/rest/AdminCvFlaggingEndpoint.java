package com.qa.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.business.AdminCvFlagService;

@CrossOrigin
@RequestMapping("${URL.base.AdminFlagging}")
@RestController
public class AdminCvFlaggingEndpoint {

	@Autowired
	AdminCvFlagService service;

	@PutMapping("${URL.method.FlagUserCV}")
	public String flagCV(@PathVariable("userId") Long userId, @PathVariable("flagCv") Boolean userCvFlagged)
			throws IOException {
		return service.updateFlag(userId, userCvFlagged);
	}
}
