package com.qa.service.buisness;

import java.util.Optional;

import com.qa.persistence.domain.Comment;

public interface CommentService {

	String addComment(Comment comment);

	Iterable<Comment> getAllComments();

	Optional<Comment> getComment(Long commentId);

	String updateComment(Long commentId, Long adminId, Long userId, Long cvId, String comment);

	String deleteComment(Long commentId);

}
