package com.example.demo.repositories;

import com.example.demo.model.Comment;
import org.springframework.data.repository.CrudRepository;


public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
