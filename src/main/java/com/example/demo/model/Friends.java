package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Friends {
    @Id
    @GeneratedValue
    private int friend_id;
    //@Column(unique=true)
    private String login;

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Friends(int friend_id, String login) {
        this.friend_id = friend_id;
        this.login = login;
    }
    public Friends(){}
}
