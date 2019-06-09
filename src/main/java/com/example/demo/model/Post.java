package com.example.demo.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private int post_id;
    @ManyToOne
    private User user;
    @GeneratedValue
    private LocalDate post_date;
    private String post_title;

    public Post(String post_title, String post_content,List<Category> category, List<Comment> comment) {
        this.post_title = post_title;
        this.post_content = post_content;
        this.post_date = LocalDate.now();
        this.categoryList = category;
        this.commentList = comment;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    private String post_content;
    @ManyToMany
    private List<Category> categoryList;
    @OneToMany
    private List<Comment> commentList;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getPost_date() {
        return post_date;
    }

    public void setPost_date(LocalDate post_date) {
        this.post_date = post_date;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Post() {
    }

    public Post(int post_id, User user, LocalDate post_date, String post_content, Category category, Comment comment) {
        this.post_id = post_id;
        this.user = user;
        this.post_date = post_date;
        this.post_content = post_content;
        this.categoryList = new ArrayList<>();
        this.commentList = new ArrayList<>();
    }
}
