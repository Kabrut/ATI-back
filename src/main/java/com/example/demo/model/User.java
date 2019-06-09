package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(unique = true)
    private String login;
    private String name;
    private String surname;
    private String password;
    @Column(unique = true)
    private String email;
    private String role;
    @ManyToMany
    private List<Friends> friendsList;

    public User(String login, String name, String surname, String password, String role, String email) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
        this.friendsList = new ArrayList<>();
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public User(String login, String name, String surname, String password, String email) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Friends> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<Friends> friendsList) {
        this.friendsList = friendsList;
    }
}
