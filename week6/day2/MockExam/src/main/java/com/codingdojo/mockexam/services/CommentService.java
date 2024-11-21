package com.codingdojo.mockexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mockexam.models.Comment;
import com.codingdojo.mockexam.repositories.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository cRepo;
	 // returns all the Comments
    public List<Comment> allComments() {
        return cRepo.findAll();
    }
    // creates a Comment
    public Comment createComment(Comment comment) {
        return cRepo.save(comment);
    }
    public Comment findComment(Long id) {
        Optional<Comment> optionalComment = cRepo.findById(id);
        if(optionalComment.isPresent()) {
            return optionalComment.get();
        } else {
            return null;
        }
    }
    public void deleteComment(Long id) {
    	cRepo.deleteById(id);
    }
    
    public Comment updateComment(Comment comment) {
    	return cRepo.save(comment);
    }
}
