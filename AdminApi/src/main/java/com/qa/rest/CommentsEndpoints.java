package com.qa.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistence.domain.Comment;
import com.qa.service.buisness.CommentService;

@CrossOrigin
@RequestMapping("${URL.base.comment}")
@RestController
public class CommentsEndpoints {

	@Autowired
	private CommentService service;

	@GetMapping("${URL.method.getAllComments}")
	public Iterable<Comment> getAllComments() {
		return service.getAllComments();
	}

	@GetMapping("${URL.method.getComment}")
	public Optional<Comment> getComment(@PathVariable("commentId") Long commentId) {
		return service.getComment(commentId);
	}

	@PostMapping("${URL.method.addComment}")
	public String addComment(@RequestBody Comment comment) {
		return service.addComment(comment);
	}
	
//	{
//		"adminId" : "ahmedmardi",
//	    "userId": "ahmed",
//	    "cvId": "ahmedmardiosman@gmail.com",
//		"cvFlag" : "true",
//		"Comment" : "the cv is very good"
//	}

	@PutMapping("${URL.method.updateComment}")
	public String updateComment(@PathVariable("commentId") Long commentId, @PathVariable("adminId") Long adminId,
			@PathVariable("userId") Long userId, @PathVariable("cvId") Long cvId, @RequestBody String Comment) {
		return service.updateComment(commentId, adminId, userId, cvId, Comment);
	}
	
	@DeleteMapping("${URL.method.deleteComment}")
	public String deleteComment(@PathVariable("commentId") Long commentId) {
		return service.deleteComment(commentId);
	}

}
