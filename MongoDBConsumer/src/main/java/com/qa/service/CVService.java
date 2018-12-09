package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.CVBinary;
import com.qa.repository.CVsRepository;

@Service
public class CVService {

	
	@Autowired
	private CVsRepository cvRepo;

	public CVBinary add(CVBinary binaryCv) {
		return cvRepo.save(binaryCv);
	}
}
