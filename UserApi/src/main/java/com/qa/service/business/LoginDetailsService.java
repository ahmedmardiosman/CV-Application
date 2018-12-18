package com.qa.service.business;

import com.qa.persistence.domain.LoginDetails;
import com.qa.service.business.LoginDetailsServiceImpl.Response;

public interface LoginDetailsService {

	Response checkLoginDetials(LoginDetails loginDetails);

}
