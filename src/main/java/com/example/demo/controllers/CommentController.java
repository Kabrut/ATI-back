package com.example.demo.controllers;

import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.PostRepository;
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
    @Autowired
    PostRepository postRepository;
//    @PostMapping("/comments")
//    public ResponseEntity addComment(@RequestParam Comment comment) {
//        commentRepository.save(comment);
//        return new ResponseEntity(HttpStatus.OK);
 //   }
    @DeleteMapping("/comments/{id}")
    public ResponseEntity deleteComment(@PathVariable int id){
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        Post post = comment.getPost();
        List<Comment> commentList = post.getCommentList();
        commentList.remove(comment);
        post.setCommentList(commentList);
        commentRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/showComment/{id}")
    public List<Comment> getPostById(@PathVariable int id){
        Post post= postRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return post.getCommentList();
    }

//    @GetMapping("/showComment")
//    public ArrayList<Comment> getAllComments() {
//        Iterable<Comment> comment = commentRepository.findAll();
//        return String.valueOf((ArrayList<Comment>) comment);
//   }
    @RequestMapping(path = "/comment/post/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addComment(@RequestParam String comment_content, @PathVariable int id ) {
        Post post= postRepository.findById(id).orElseThrow(() -> new RuntimeException());
        List<Comment> list = post.getCommentList();
        Comment comment = new Comment(comment_content,post);
        list.add(comment);
        post.setCommentList(list);
        commentRepository.save(comment);
        return String.valueOf(comment.getComment_id());
    }


}