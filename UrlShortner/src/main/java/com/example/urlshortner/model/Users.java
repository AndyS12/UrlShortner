package com.example.urlshortner.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    Integer id;
    Integer userId;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
