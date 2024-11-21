package com.codingdojo.mockexam.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mockexam.models.Comment;

@Repository
public interface CommentRepository extends ListCrudRepository<Comment, Long> {

}
