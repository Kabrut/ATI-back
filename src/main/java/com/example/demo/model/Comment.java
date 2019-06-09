package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int comment_id;
    @ManyToOne
    private User user;
    private String comment_content;
    private boolean report;



    public Comment(String comment_content) {
        this.comment_content = comment_content;
        this.report = false;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public Comment() {
    }
}
