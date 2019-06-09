package com.example.demo.controllers;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

//    @PostMapping("/comments")
//    public ResponseEntity addComment(@RequestParam Comment comment) {
//        commentRepository.save(comment);
//        return new ResponseEntity(HttpStatus.OK);
//    }
    @DeleteMapping("/comments/{id}")
    public ResponseEntity deleteComment(@PathVariable int id){
        commentRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/showComment")
    public ArrayList<Comment> getAllComments() {
        Iterable<Comment> comment = commentRepository.findAll();
        return (ArrayList<Comment>) comment;
    }
    @RequestMapping(path = "/comment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addComment(@RequestParam String comment_content) {
        Comment comment = new Comment(comment_content);
        commentRepository.save(comment);
        return String.valueOf(comment.getComment_id());
    }


}