package com.example.demo.controllers;

import com.example.demo.model.Category;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {
    @Autowired
    PostRepository postRepository;




    @PostMapping(path = "/posts")
    public ResponseEntity addPost(@RequestBody Post post) {
        postRepository.save(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/show")
    public List<Post> getAllPosts(){
        Iterable<Post> post = postRepository.findAll();
        return (ArrayList<Post>) post;
    }


    @DeleteMapping(path="/posts/{id}")
    public ResponseEntity deletePost(@PathVariable int id){
        postRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(path = "/post", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String addPost(@RequestParam String post_title, @RequestParam String post_content, @RequestParam List<Category> categoryList, @RequestParam List<Comment> commentList) {
        Post post = new Post(post_title, post_content, categoryList, commentList);
        postRepository.save(post);
        return String.valueOf(post.getPost_date());
    }




}
