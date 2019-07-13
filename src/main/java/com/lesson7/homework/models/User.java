package com.lesson7.homework.models;

import javax.persistence.*;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private String phone;
    private String password;
    private List<Post> posts;

    @Id
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "SEQUENCE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @OneToMany(mappedBy = "userPosted")
    public List<Post> getPosts() {
        return posts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
