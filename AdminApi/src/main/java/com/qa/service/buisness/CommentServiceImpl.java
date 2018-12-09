package com.qa.service.buisness;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Comment;
import com.qa.persistence.repository.CommentsRepository;
import com.qa.util.CommentProducerJMS;
import com.qa.util.CommentSender;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentsRepository commentsRepo;

	@Autowired
	private CommentProducerJMS commentProducer;

	@Autowired
	private CommentSender commentInfo;

	public String addComment(Comment comment) {

		commentsRepo.save(comment);
		commentProducer.produce(comment);
		commentInfo.send(comment);

		return "Your comment has been saved";
	}

	public Iterable<Comment> getAllComments() {
		return commentsRepo.findAll();
	}

	public Optional<Comment> getComment(Long commentId) {
		return commentsRepo.findById(commentId);
	}

	public String updateComment(Long commentId, Long adminId, Long userId, Long cvId, String comment) {

		Comment updatedComment = new Comment();
		updatedComment.setCommentId(commentId);
		updatedComment.setAdminId(adminId);
		updatedComment.setUserId(userId);
		updatedComment.setCvId(cvId);
		updatedComment.setComment(comment);

		commentsRepo.save(updatedComment);

		return "Comment has been successfully updated";
	}

	public String deleteComment(Long commentId) {
		commentsRepo.deleteById(commentId);
		return "Comment has been successfully deleted";
	}

}
