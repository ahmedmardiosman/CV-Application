package com.qa.service.buisness;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.AdminUser;
import com.qa.persistence.repository.AdminUserRepository;
import com.qa.util.AdminUserProducerJMS;
import com.qa.util.EmailSender;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserRepository adminUserRepo;

	@Autowired
	private AdminUserProducerJMS adminUserProducer;

	@Autowired
	private EmailSender emailSender;

	public String addAdminAccount(AdminUser adminUser) {

		adminUser.setPassword(BCrypt.hashpw(adminUser.getPassword(), BCrypt.gensalt()));	
		
		if (adminUser.getIsSuperAdmin() == true) {
			
			saveAndProduce(adminUser);
			try {
				emailSender.sendEmail(adminUser);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
			return "Admin Account Added Successfully and Email Notification Sent";
		}else {
			saveAndProduce(adminUser);
			return "Admin Account Added Successfully";
		}
		
	}

	public void saveAndProduce(AdminUser adminUser) {
		adminUserRepo.save(adminUser);
		adminUserProducer.produce(adminUser);

	}

	public Iterable<AdminUser> getAllAdminAccounts() {
		return adminUserRepo.findAll();
	}

	public Optional<AdminUser> getAdminAccount(Long adminId) {
		return adminUserRepo.findById(adminId);
	}

	public String updateAdminAccount(Long adminId, String adminUserName, String password) {

		AdminUser adminUser = new AdminUser();
		adminUser.setAdminId(adminId);
		adminUser.setAdminUserName(adminUserName);
		adminUser.setPassword(password);
		adminUser.setComments(adminUserRepo.findById(adminId).get().getComments());
		adminUserRepo.save(adminUser);

		return "Admin Account has been successfully updated";
	}

	public String deleteAdminAccount(Long adminId) {
		adminUserRepo.deleteById(adminId);
		return "Admin User Successfully Deleted";

	}

}
