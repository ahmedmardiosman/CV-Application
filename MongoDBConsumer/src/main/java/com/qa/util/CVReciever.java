package com.qa.util;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.qa.persistence.domain.CV;
import com.qa.persistence.domain.CVBinary;
import com.qa.service.CVService;

@Component
public class CVReciever {
	
	@Autowired
	private CVService service;

	@JmsListener(destination = "CVDetailsForMongoDB", containerFactory = "myFactory")
	public void receiveMessage(CV cv) {
		CVBinary binaryCV = new CVBinary();
		binaryCV.setCvId(cv.getCvId());
		binaryCV.setUserId(cv.getUserId());
		binaryCV.setFileName(cv.getFileName());
		binaryCV.setCvFile(new Binary(BsonBinarySubType.BINARY,cv.getCvFile()));
		service.add(binaryCV);
	}
}
