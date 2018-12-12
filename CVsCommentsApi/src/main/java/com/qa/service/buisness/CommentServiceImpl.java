package com.qa.service.buisness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Comment;
import com.qa.persistence.repository.CVRepository;
import com.qa.persistence.repository.CommentsRepository;
import com.qa.util.EmailSender;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentsRepository commentRepo;
	
	@Autowired
	private CVRepository cvRepo;

	@Autowired
	private EmailSender emailSender;
	
	public String transferComment(Comment comment) {
		
		
		if( comment.getCvFlag() == true) {
			
			String userEmail = cvRepo.findById(comment.getCvId()).get().getUserEmail();
			emailSender.sendFlaggedCommentEmail(comment.getUserId(), userEmail);
			commentRepo.save(comment);
			return "Comment has been transfered to CV and Comments Database and User has been notified of new comment";
		}else {

		commentRepo.save(comment);
		return "Comment has been transfered to CV and Comments Database";
		}

	}

}
