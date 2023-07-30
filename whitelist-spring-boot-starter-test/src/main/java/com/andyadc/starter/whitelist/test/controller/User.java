package com.andyadc.starter.whitelist.test.controller;

import java.time.LocalDateTime;

public class User {

    private String code;
    private String message;

    private String username;
    private LocalDateTime time;

    public User() {
        this.time = LocalDateTime.now();
    }

    public User(String username) {
        this();
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
